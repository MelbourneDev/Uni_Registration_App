package course_reg_app.service

import course_reg_app.models.User
import course_reg_app.repository.UserRepository
import org.springframework.stereotype.Service



@Service
class AuthService(
    private val userRepository: UserRepository,

) {
    fun authenticateUser(username: String, password: String): User? {
        val user = userRepository.findByUsernameAndPassword(username, password)
        return user.orElse(null)

    }

}


