package course_reg_app.service


import org.springframework.stereotype.Service

@Service
class UserService{

    fun validatePassword(password: String): Boolean {
        return password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^\\da-zA-Z]).{8,}$".toRegex())
    }

}