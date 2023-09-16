package core.commandManager.models

import core.commandManager.models.interfaces.SlashCommandInterface
import dev.kord.common.entity.Permission
import dev.kord.core.Kord
import dev.kord.core.event.interaction.GuildChatInputCommandInteractionCreateEvent

open class SlashCommand(
    override var commandName: String = "",
    override var commandDescription: String = "",
    override var commandPermissions: MutableList<Permission> = mutableListOf(),
    override var commandOption: HashMap<String, String> = HashMap(),
    override val guildOnly: Boolean = false,
    override val nsfwOnly: Boolean = false
) : SlashCommandInterface {
    override suspend fun execute(event: GuildChatInputCommandInteractionCreateEvent, kord: Kord) {}
}