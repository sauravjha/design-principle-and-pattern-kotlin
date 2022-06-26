package pattern.creational.abstractfactory

import java.lang.IllegalArgumentException

/*
    https://medium.com/@dbottillo/patterns-in-kotlin-abstract-factory-a0ff99a0d177
*/

interface Chat {
    fun getChannel(): List<Channel>
    fun getMessage(channelId: Long): List<Message>
}

data class Channel(
    val id: Long,
    val name: String,
    val user: List<User>
)

data class Message(
    val id: Long,
    val text: String
)

sealed class User {
    object Self: User()
    class Other(val name: String): User()
}

abstract class ChatFactory {
    abstract fun getChat(): Chat

    companion object {
        inline fun <reified T: Chat> create(): ChatFactory {
            return when(T::class) {
                FakeChat::class -> FakeChatFactory()
                SDKChat::class -> SDKChatFactory()
                else -> throw IllegalArgumentException("")
            }
        }
    }
}

class FakeChat: Chat {
    override fun getChannel(): List<Channel> {
        TODO("Not yet implemented")
    }

    override fun getMessage(channelId: Long): List<Message> {
        TODO("Not yet implemented")
    }
}

class SDKChat: Chat {
    override fun getChannel(): List<Channel> {
        TODO("Not yet implemented")
    }

    override fun getMessage(channelId: Long): List<Message> {
        TODO("Not yet implemented")
    }
}

class FakeChatFactory: ChatFactory() {
    override fun getChat(): Chat {
        TODO("Not yet implemented")
    }
}

class SDKChatFactory: ChatFactory() {
    override fun getChat(): Chat {
        TODO("Not yet implemented")
    }
}


fun main() {
    ChatFactory.create<FakeChat>().getChat().getChannel()
    ChatFactory.create<SDKChat>().getChat().getChannel()
}