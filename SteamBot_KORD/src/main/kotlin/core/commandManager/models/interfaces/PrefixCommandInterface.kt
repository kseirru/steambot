package core.commandManager.models.interfaces

import dev.kord.common.entity.Permission
import dev.kord.core.Kord
import dev.kord.core.event.message.MessageCreateEvent

interface PrefixMessageInterface {
    var commandName: String
    var commandDescription: String
    var commandPermissions: MutableList<Permission>


    // TODO: Also create custom PrefixMessageContext instead of this
    @Override
    suspend fun execute(event: MessageCreateEvent, kord: Kord) {}
}