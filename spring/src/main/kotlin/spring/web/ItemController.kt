package spring.web

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/items")
class ItemController {
    @GetMapping("/{id}")
    fun get(
        @PathVariable id: String,
        @RequestParam(defaultValue = "en") lang: String,
        @RequestHeader(value = "X-Trace", required = false) trace: String?
    ) = ItemResponse(id, "$lang:${trace ?: "none"}")

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody body: ItemRequest) = ItemResponse("1", body.name)

    @PutMapping("/{id}")
    fun update(@PathVariable id: String, @RequestBody body: ItemRequest) = ItemResponse(id, body.name)

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: String) {
    }
}
