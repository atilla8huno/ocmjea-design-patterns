package designpatterns.behavioral.mediator

class ChatMediatorImpl : ChatMediator {
    private val users = mutableListOf<User>()

    override fun sendMessage(msg: String, user: User) {
        for (u in users) {
            if (u !== user) {
                u.receive(msg)
            }
        }
    }

    override fun addUser(user: User) {
        users.add(user)
    }
}
