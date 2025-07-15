package studikasus.restfulapi.belajar.service

import jakarta.validation.Validator
import org.hibernate.validator.constraints.UUID
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import studikasus.restfulapi.belajar.entity.User
import studikasus.restfulapi.belajar.model.LoginUserRequest
import studikasus.restfulapi.belajar.model.TokenResponse
import studikasus.restfulapi.belajar.repository.UserRepository

@Service
class AuthService (
    @Autowired
    val userRepository: UserRepository,

    @Autowired
    val validator: Validator
) {
    fun tokenExpiredAt():Long{
        return System.currentTimeMillis() + (1000 * 60 * 60 * 24)
    }

    @Transactional
    fun login (request: LoginUserRequest): TokenResponse{
        if (request.username.isBlank() || request.password.isBlank()){
            throw IllegalArgumentException("Data tidak boleh kosong")
        }

        val user:User = userRepository.findById(request.username)
            .orElseThrow{IllegalArgumentException("Username tidak ditemukan")}

        if (user.password != request.password){
            throw IllegalArgumentException("Password salah")
        }

        user.token = java.util.UUID.randomUUID().toString()
        user.tokenExpireAt = tokenExpiredAt()

        userRepository.save(user)

        val token = user.token ?: throw IllegalArgumentException("Token belum dibuat")
        val tokenExpiredAt = user.tokenExpireAt ?: throw IllegalArgumentException("Token belum dibuat")

        return TokenResponse(token, tokenExpiredAt)
    }

}