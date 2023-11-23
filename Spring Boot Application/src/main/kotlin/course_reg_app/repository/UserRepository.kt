package course_reg_app.repository

import course_reg_app.models.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface UserRepository : JpaRepository<User, Long> {

    // validation for user controller registration process
    fun existsByUsername(username: String): Boolean
    fun existsByEmail(email: String): Boolean
    // validation for the user login
    fun findByUsernameAndPassword(username: String, password: String): Optional<User>

}


