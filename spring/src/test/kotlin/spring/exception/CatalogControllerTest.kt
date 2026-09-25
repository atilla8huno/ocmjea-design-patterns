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

/** @ControllerAdvice and @ExceptionHandler for a missing resource. */
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
