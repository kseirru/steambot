package core.commandManager

import core.commandManager.managers.PrefixCommandManager
import core.commandManager.managers.SlashCommandManager
import dev.kord.core.Kord
import dev.kord.core.event.interaction.GuildChatInputCommandInteractionCreateEvent
import dev.kord.core.event.message.MessageCreateEvent
import dev.kord.core.on

class CommandManager {
    val slashCommandManager = SlashCommandManager()
    val prefixCommandManager = PrefixCommandManager()

    suspend fun handle(kord: Kord) {

        slashCommandManager.registerCommands(kord)

        kord.on<MessageCreateEvent> {
            prefixCommandManager.executePrefixCommand(this, kord)
        }

        kord.on<GuildChatInputCommandInteractionCreateEvent> {
            slashCommandManager.executeSlashCommand(this, kord)
        }
    }
}