package commands

import core.commandManager.models.SlashCommand
import dev.kord.common.Color
import dev.kord.core.Kord
import dev.kord.core.behavior.interaction.respondEphemeral
import dev.kord.core.event.interaction.GuildChatInputCommandInteractionCreateEvent
import dev.kord.rest.builder.message.create.embed
class SlashCommandExample : SlashCommand() {
    init {
        this.commandName = "example"
        this.commandDescription = "This is slash command example"
    }

    override suspend fun execute(event: GuildChatInputCommandInteractionCreateEvent, kord: Kord) {
        event.interaction.respondEphemeral {
            embed {
                title = "Проверка пройдена!"
                color = Color(0x66CCCC)
                description = "Проверка успешно пройдена!"
            }
        }
    }
}