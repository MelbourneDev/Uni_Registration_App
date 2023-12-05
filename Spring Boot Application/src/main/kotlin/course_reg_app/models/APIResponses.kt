package course_reg_app.models

class APIResponses {
    // string to handle registration responses
    data class RegistrationResponse(val token: String, val message: String)
    data class RegistrationBadResponse(val message: String)

    // string token and message for login response
    data class LoginResponse(val token: String, val message: String)

    data class LoginRequest(val username: String, val password: String)

    data class UserDetailsResponse(val message: String)

    data class DepartmentResponse(val message: String)

}