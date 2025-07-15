package studikasus.restfulapi.belajar.resolver

import org.springframework.core.MethodParameter
import org.springframework.stereotype.Component
import org.springframework.web.bind.support.WebDataBinderFactory
import org.springframework.web.context.request.NativeWebRequest
import org.springframework.web.method.support.HandlerMethodArgumentResolver
import org.springframework.web.method.support.ModelAndViewContainer
import studikasus.restfulapi.belajar.entity.User
import studikasus.restfulapi.belajar.repository.UserRepository

@Component
class UserArgumentResolver(
    private val userRepository: UserRepository
) : HandlerMethodArgumentResolver {

    override fun supportsParameter(parameter: MethodParameter): Boolean {
        // Mendukung parameter bertipe User
        return parameter.parameterType == User::class.java
    }

    override fun resolveArgument(
        parameter: MethodParameter,
        mavContainer: ModelAndViewContainer?,
        webRequest: NativeWebRequest,
        binderFactory: WebDataBinderFactory?
    ): Any? {
        val authHeader = webRequest.getHeader("Authorization")
            ?: throw IllegalArgumentException("Authorization header tidak ditemukan")

        if (!authHeader.startsWith("Bearer ")) {
            throw IllegalArgumentException("Format Authorization salah")
        }

        val token = authHeader.removePrefix("Bearer ").trim()

        val user = userRepository.findByToken(token)
            ?: throw IllegalArgumentException("Token tidak valid atau user tidak ditemukan")

        println("User ditemukan: $user")

        return user
    }

}
