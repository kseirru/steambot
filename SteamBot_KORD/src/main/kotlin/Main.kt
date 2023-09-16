import com.uchuhimo.konf.Config
import com.uchuhimo.konf.ConfigSpec
import commands.PrefixCommandExample
import commands.SlashCommandExample
import core.commandManager.CommandManager
import dev.kord.core.Kord
import dev.kord.gateway.Intents
import dev.kord.gateway.PrivilegedIntent

suspend fun main() {
    val config = Config { addSpec(BotConfig) }
        .from.json.resource("config.json")

    val kord = Kord(
        config[BotConfig.discord_token]
    )

    val commandManager = CommandManager()

    commandManager.prefixCommandManager.setPrefix(config[BotConfig.discord_prefix])

    commandManager.slashCommandManager.addSlashCommand(SlashCommandExample())
    commandManager.prefixCommandManager.addCommand(PrefixCommandExample())

    commandManager.handle(kord)

    kord.login {
        @OptIn(PrivilegedIntent::class)
        intents += Intents.all
    }
}

object BotConfig : ConfigSpec() {
    val discord_token by required<String>("discord_token")
    val steam_api_key by required<String>("steam_api_key")
    val discord_prefix by required<String>("command_prefix")
}