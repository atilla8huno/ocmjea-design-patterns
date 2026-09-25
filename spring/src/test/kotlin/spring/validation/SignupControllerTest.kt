package spring.validation

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc
import spring.application.SampleApplication
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

/**
 * Bean Validation
 *
 * Declare constraints on the request type (@NotBlank, @Email, and so on).
 * @Valid on the controller argument runs them; a failure becomes 400
 * without hand-written checks in the handler.
 *
 * This test posts invalid signup input and checks the 400 response.
 */
@SpringBootTest(classes = [SampleApplication::class])
@AutoConfigureMockMvc
class SignupControllerTest @Autowired constructor(
    private val mockMvc: MockMvc
) {
    @Test
    fun acceptsAValidSignup() {
        mockMvc.perform(
            post("/signup")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""{"name":"Ada","password":"secret123","age":21}""")
        ).andExpect(status().isCreated)
    }

    @Test
    fun rejectsAnInvalidSignup() {
        mockMvc.perform(
            post("/signup")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""{"name":"","password":"x","age":10}""")
        ).andExpect(status().isBadRequest)
    }
}
