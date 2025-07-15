package studikasus.restfulapi.belajar.model

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class LoginUserRequest (
    @NotBlank
    @Size(max = 100)
    var username: String = "",

    @NotBlank
    @Size(max = 100)
    var password: String = ""
)