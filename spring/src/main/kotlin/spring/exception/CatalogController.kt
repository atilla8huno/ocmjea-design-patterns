package spring.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestController
@RequestMapping("/catalog")
class CatalogController {
    @GetMapping("/{id}")
    fun byId(@PathVariable id: String): Map<String, String> {
        if (id == "missing") {
            throw NotFoundException("id $id")
        }
        return mapOf("id" to id)
    }
}

@RestControllerAdvice
class ApiExceptionHandler {
    @ExceptionHandler(NotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun notFound(ex: NotFoundException) = mapOf("error" to (ex.message ?: "not found"))
}
