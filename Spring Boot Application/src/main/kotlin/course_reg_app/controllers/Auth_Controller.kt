package course_reg_app.controllers

import course_reg_app.models.APIResponses
import course_reg_app.service.AuthService
import course_reg_app.service.JwTService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/auth")
class Auth_Controller(
        private val authService: AuthService,
        private val jwtService: JwTService
)

{
    @PostMapping("/login")
    fun loginUser(@RequestBody loginRequest: APIResponses.LoginRequest): ResponseEntity<APIResponses.LoginResponse>{
        val userExists = authService.authenticateUser(loginRequest.username, loginRequest.password)
        return if (userExists){
            val token = jwtService.generateToken(loginRequest.username)
            ResponseEntity.ok(APIResponses.LoginResponse(token, "Login Successful"))
        } else {
            ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(APIResponses.LoginResponse("","Invalid credentials"))
        }
    }
}