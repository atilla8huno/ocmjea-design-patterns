package designpatterns.behavioral.mediator

import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Test

/**
 * Mediator (Behavioural)
 *
 * Route communication through one object so colleagues do not hold each other.
 * Users send to ChatMediator; the mediator delivers to the other users.
 * Adding a user does not change the existing ones.
 *
 * Applicable when many-to-many links would become a mesh. This test sends
 * a message from one user and delivers it to the others.
 */
class ChatTest {
    @Test
    fun `sends messages between users via the mediator`() {
        val mediator: ChatMediator = ChatMediatorImpl()

        val user1: User = UserImpl("Atilla", mediator)
        val user2: User = UserImpl("Jullierme", mediator)
        val user3: User = UserImpl("Ben-Hur", mediator)
        val user4: User = UserImpl("Maria Rosa", mediator)

        assertDoesNotThrow {
            user1.send("Hey, everyone...")
            user4.send("Good morning, lovely family!")
            user2.send("Is there lunch? I am coming over to eat...")
            user3.send("You are coming to my birthday, right?!")
        }
    }
}
