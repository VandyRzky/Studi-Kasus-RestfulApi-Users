package studikasus.restfulapi.belajar.service

import jakarta.validation.ConstraintViolation
import jakarta.validation.Validator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import studikasus.restfulapi.belajar.entity.User
import studikasus.restfulapi.belajar.model.RegisterUserRequest
import studikasus.restfulapi.belajar.model.UserResponse
import studikasus.restfulapi.belajar.repository.UserRepository

@Service
class UserService (
    @Autowired
    val userRepository: UserRepository,

    @Autowired
    val validator: Validator
){
    fun register(request: RegisterUserRequest): User {
        // 1. Cek apakah username sudah digunakan
        if (userRepository.existsById(request.username)) {
            throw IllegalArgumentException("Username sudah digunakan")
        }

        if (request.username.isBlank() || request.password.isBlank() || request.name.isBlank()){
            throw IllegalArgumentException("Data tidak boleh kosong")
        }

        // 2. Buat User entity langsung tanpa hash password
        val user = User(
            username = request.username,
            password = request.password,
            name = request.name,
            token = "",
            tokenExpireAt = null
        )

        // 3. Simpan ke database
        return userRepository.save(user)
    }

    fun get(user: User):UserResponse{
        return UserResponse(user.username, user.name)
    }
}