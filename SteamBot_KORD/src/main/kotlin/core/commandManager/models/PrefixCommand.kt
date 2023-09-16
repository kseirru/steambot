package core.commandManager.models

import core.commandManager.models.interfaces.PrefixMessageInterface
import dev.kord.common.entity.Permission
import dev.kord.core.Kord
import dev.kord.core.event.message.MessageCreateEvent

open class PrefixCommand(
    override var commandName: String = "",
    override var commandDescription: String = "",
    override var commandPermissions: MutableList<Permission> = mutableListOf()
) : PrefixMessageInterface {
    override suspend fun execute(event: MessageCreateEvent, kord: Kord) {}
}