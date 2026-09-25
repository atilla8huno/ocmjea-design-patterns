package spring.validation

import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class SignupRequest(
    @field:NotBlank
    val name: String,
    @field:Size(min = 8, max = 40)
    val password: String,
    @field:Min(18)
    val age: Int
)
