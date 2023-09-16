package core.commandManager.managers

import core.commandManager.models.SlashCommand
import dev.kord.core.Kord
import dev.kord.core.event.interaction.GuildChatInputCommandInteractionCreateEvent

class SlashCommandManager {
    private val commandList: MutableList<SlashCommand> = mutableListOf()

    fun addSlashCommand(slashCommand: SlashCommand) {
        this.commandList.add(slashCommand)
    }

    suspend fun registerCommands(kord: Kord) {
        for (command in this.commandList) {
            kord.createGlobalChatInputCommand(
                command.commandName,
                command.commandDescription
            )
        }
    }

    suspend fun executeSlashCommand(event: GuildChatInputCommandInteractionCreateEvent, kord: Kord) {
        for (command in this.commandList) {
            if(event.interaction.command.rootName.lowercase() == command.commandName.lowercase()) {
                command.execute(event, kord)
                break
            }
        }
    }

}