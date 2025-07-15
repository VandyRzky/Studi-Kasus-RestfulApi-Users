package studikasus.restfulapi.belajar.controller

import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import studikasus.restfulapi.belajar.entity.User
import studikasus.restfulapi.belajar.model.RegisterUserRequest
import studikasus.restfulapi.belajar.model.UserResponse
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


    @GetMapping("/api/users/current")
    fun get(user: User): UserResponse {
        val userResponse = userService.get(user)
        return userResponse
    }
}