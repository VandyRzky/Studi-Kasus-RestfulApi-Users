package studikasus.restfulapi.belajar.controller

import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import studikasus.restfulapi.belajar.model.RegisterUserRequest
import studikasus.restfulapi.belajar.model.WebResponse
import studikasus.restfulapi.belajar.service.UserService

@RestController
class UserController (
    @Autowired
    val userService: UserService,
) {

    @PostMapping("/api/users")
    fun register(@Valid @RequestBody request: RegisterUserRequest): WebResponse<String> {
        userService.register(request)
        return WebResponse(data = "Registrasi berhasil")
    }
}