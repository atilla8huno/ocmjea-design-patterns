package designpatterns.structural.proxy

import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Test

/**
 * Proxy (Structural)
 *
 * Stand in for another object and control access to it. ImageProxy looks like
 * an Image; it loads the RealImage only on the first display and reuses it
 * afterwards (virtual / lazy proxy).
 *
 * Applicable when creation is expensive or you need access control. This test
 * displays the same ImageProxy twice.
 */
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
