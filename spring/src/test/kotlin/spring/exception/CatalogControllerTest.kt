package spring.exception

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc
import spring.application.SampleApplication
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

/**
 * Exception handling
 *
 * Keep controllers free of try/catch for expected failures.
 * @RestControllerAdvice plus @ExceptionHandler map an exception type to
 * an HTTP status and body, so every missing resource looks the same.
 *
 * This test requests a missing catalog id and checks the status and payload.
 */
@SpringBootTest(classes = [SampleApplication::class])
@AutoConfigureMockMvc
class CatalogControllerTest @Autowired constructor(
    private val mockMvc: MockMvc
) {
    @Test
    fun returnsTheItem() {
        mockMvc.perform(get("/catalog/1"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.id").value("1"))
    }

    @Test
    fun mapsNotFound() {
        mockMvc.perform(get("/catalog/missing"))
            .andExpect(status().isNotFound)
            .andExpect(jsonPath("$.error").value("id missing"))
    }
}
