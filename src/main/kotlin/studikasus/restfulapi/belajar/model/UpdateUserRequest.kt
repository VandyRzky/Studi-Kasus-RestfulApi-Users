package studikasus.restfulapi.belajar.model

import jakarta.validation.constraints.Size

data class UpdateUserRequest (
    @Size(max = 100)
    var name: String,
    @Size(max = 100)
    var password: String,
)