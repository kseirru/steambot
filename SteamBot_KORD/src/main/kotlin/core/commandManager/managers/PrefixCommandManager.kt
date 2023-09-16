package core.commandManager.managers

import core.commandManager.models.PrefixCommand
import dev.kord.core.Kord
import dev.kord.core.event.message.MessageCreateEvent

class PrefixCommandManager {
    private var commandList: MutableList<PrefixCommand> = mutableListOf()
    private var prefix: String = "!"

    fun addCommand(prefixCommand: PrefixCommand) {
        this.commandList.add(prefixCommand)
    }

    fun removeCommand(commandName: String) {
        for (command in this.commandList) {
            if (command.commandName == commandName) {
                this.commandList.remove(command)
            }
        }
    }

    fun setPrefix(newPrefix: String) {
        this.prefix = newPrefix
    }

    suspend fun executePrefixCommand(event: MessageCreateEvent, kord: Kord) {
        for (command in this.commandList) {
            val commandPrefix = "${this.prefix}${command.commandName}"
            if(event.message.content.lowercase().startsWith(commandPrefix.lowercase())) {
                command.execute(event, kord)
                break
            }
        }
    }
}