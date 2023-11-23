package course_reg_app.models

class APIResponses {
    // string to handle registration responses
    data class RegistrationResponse(val message: String)
    // string token and message for login response
    data class LoginResponse(val token: String,
                             val message: String)

    data class LoginRequest(val username: String, val password: String)


}