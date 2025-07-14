package studikasus.restfulapi.belajar.model

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class RegisterUserRequest (
    @NotBlank
    @Size(max = 100)
    var username: String = "",

    @NotBlank
    @Size(max = 100)
    var password: String = "",

    @NotBlank
    @Size(max = 100)
    var name: String = ""
)