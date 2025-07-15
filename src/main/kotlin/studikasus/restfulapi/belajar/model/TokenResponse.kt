package studikasus.restfulapi.belajar.model


data class TokenResponse(
    var token: String,
    var tokenExpireAt: Long,
)
