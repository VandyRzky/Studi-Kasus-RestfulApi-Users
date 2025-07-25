package studikasus.restfulapi.belajar.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table


@Entity
@Table(name = "users")
data class User(
    @Id
    var username: String = "",

    var password: String = "",

    var name: String = "",

    var token: String? = "",

    @Column(name = "token_expired_at")
    var tokenExpireAt: Long? = null
)
