package studikasus.restfulapi.belajar.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import studikasus.restfulapi.belajar.entity.User

@Repository
interface UserRepository: JpaRepository<User, String> {
    fun findByToken(token: String): User?
}