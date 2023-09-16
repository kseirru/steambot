package commands

import core.commandManager.models.PrefixCommand
import dev.kord.common.Color
import dev.kord.core.Kord
import dev.kord.core.behavior.channel.createEmbed
import dev.kord.core.event.message.MessageCreateEvent

class PrefixCommandExample : PrefixCommand() {
    init {
        this.commandName = "example"
    }

    override suspend fun execute(event: MessageCreateEvent, kord: Kord) {
        event.message.channel.createEmbed {
            title = "Проверка пройдена!"
            color = Color(0x66CCCC)
            description = "Проверка успешно пройдена!"
        }
    }
}