package studikasus.restfulapi.belajar.controller

import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import studikasus.restfulapi.belajar.entity.User
import studikasus.restfulapi.belajar.model.LoginUserRequest
import studikasus.restfulapi.belajar.model.TokenResponse
import studikasus.restfulapi.belajar.model.WebResponse
import studikasus.restfulapi.belajar.service.AuthService


@RestController
class AuthController (
    @Autowired
    val authService: AuthService
) {
    @PostMapping("/api/auth/login")
    fun login(@Valid @RequestBody request:LoginUserRequest):WebResponse<TokenResponse>{
        val tokenResponse = authService.login(request)
        return WebResponse(tokenResponse)

    }

    @DeleteMapping("/api/auth/logout")
    fun logout(user: User): WebResponse<String>{
        authService.logout(user)

        return WebResponse(data = "Berhasil logout")
    }
}