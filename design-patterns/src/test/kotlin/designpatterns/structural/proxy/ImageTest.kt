package designpatterns.structural.proxy

import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Test

/** Covers Proxy by displaying an image twice through ImageProxy. */
class ImageTest {
    @Test
    fun `loads the real image only on first display`() {
        val image: Image = ImageProxy("test_10mb.jpg")

        assertDoesNotThrow {
            image.display()
            image.display()
        }
    }
}
