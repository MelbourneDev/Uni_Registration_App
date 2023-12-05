package course_reg_app.controllers

import course_reg_app.models.APIResponses
import course_reg_app.models.Student
import course_reg_app.models.User
import course_reg_app.repository.StudentRepository
import course_reg_app.repository.UserRepository
import course_reg_app.service.JwTService
import org.springframework.http.ResponseEntity
import org.springframework.http.HttpStatus
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/user")
class User_Controller(
    private val userRepository: UserRepository,
    private val studentRepository: StudentRepository,
    private val jwtService: JwTService

) {
    @Transactional
    @PostMapping("/register")
    fun registerUser(@RequestBody user: User): ResponseEntity<Any> {
        // Validate that the username or email doesn't already exist in the system.
        if (userRepository.existsByUsername(user.username) || userRepository.existsByEmail(user.email)) {
            return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(APIResponses.RegistrationBadResponse("Username or Email already exists"))
        }

// save the user in the user entity as well as the student entity.
        val savedUser = userRepository.save(user)
        val newStudent = Student(user = savedUser)
        val savedStudent = studentRepository.save(newStudent)
// generate token for that users session as after registration they will be logged in automatically.
    val token = jwtService.generateToken(user.username)
    return ResponseEntity.ok(APIResponses.RegistrationResponse(token,"Student successfully registered"))
}
}