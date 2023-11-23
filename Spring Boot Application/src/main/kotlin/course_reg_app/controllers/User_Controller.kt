package course_reg_app.controllers

import course_reg_app.models.APIResponses
import course_reg_app.models.User
import course_reg_app.repository.UserRepository
import org.springframework.http.ResponseEntity
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/user")
class User_Controller(
    private val userRepository: UserRepository,
//    private val userService: UserService,

) {
@PostMapping("/register")
    fun registerUser(@RequestBody user: User): ResponseEntity<Any> {
        // Validate that the username or email doesn't already exist in the system.
        if (userRepository.existsByUsername(user.username)) {
            return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(APIResponses.RegistrationResponse("Username already exists"))
        }

        // Additional registration logic...
        val savedUser = userRepository.save(user)
        return ResponseEntity.ok(savedUser)
    }
}
