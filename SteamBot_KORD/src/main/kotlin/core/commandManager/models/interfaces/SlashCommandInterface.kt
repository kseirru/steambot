package core.commandManager.models.interfaces

import dev.kord.common.entity.Permission
import dev.kord.core.Kord
import dev.kord.core.event.interaction.GuildChatInputCommandInteractionCreateEvent

interface SlashCommandInterface {
    var commandName: String
    var commandDescription: String
    var commandPermissions: MutableList<Permission>

    var commandOption: HashMap<String, String>

    val guildOnly: Boolean
    val nsfwOnly: Boolean


    // TODO: Create custom SlashCommandContext instead of this...
    @Override
    suspend fun execute(event: GuildChatInputCommandInteractionCreateEvent, kord: Kord) {}
}