package spring.web

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc
import spring.application.SampleApplication
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

/** MVC mappings, path/query/header parameters and request bodies. */
@SpringBootTest(classes = [SampleApplication::class])
@AutoConfigureMockMvc
class ItemControllerTest @Autowired constructor(
    private val mockMvc: MockMvc
) {
    @Test
    fun readsPathQueryAndHeader() {
        mockMvc.perform(get("/items/42").param("lang", "pt").header("X-Trace", "abc"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.name").value("pt:abc"))
    }

    @Test
    fun createsAndUpdates() {
        mockMvc.perform(post("/items").contentType(MediaType.APPLICATION_JSON).content("""{"name":"book"}"""))
            .andExpect(status().isCreated)
            .andExpect(jsonPath("$.name").value("book"))
        mockMvc.perform(put("/items/1").contentType(MediaType.APPLICATION_JSON).content("""{"name":"pen"}"""))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.id").value("1"))
        mockMvc.perform(delete("/items/1"))
            .andExpect(status().isNoContent)
    }
}
