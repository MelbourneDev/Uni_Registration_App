package course_reg_app.controllers

import course_reg_app.models.Course
import course_reg_app.models.DepartmentName
import course_reg_app.service.CourseService
import course_reg_app.service.JwTService
import course_reg_app.service.StudentService
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/courses")
class CourseController(
    private val jwtService: JwTService,
    private val courseService: CourseService,
    private val studentService: StudentService,

) {
    private val logger = LoggerFactory.getLogger(CourseController::class.java)
    @GetMapping
    fun getCourses(@RequestHeader("Authorization") authorizationHeader: String): ResponseEntity<List<String>> {
        logger.info("Received Authorization header: $authorizationHeader")
        val token = authorizationHeader.substring("Bearer ".length)
        val userId = jwtService.getUserIdFromToken(token)
        logger.info("Extracted userId: $userId")

        if (userId == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build()
        }

        val departmentNameStr = studentService.getDepartmentNameByUserId(userId)
        val departmentName = DepartmentName.valueOf(departmentNameStr ?: return ResponseEntity.status(HttpStatus.BAD_REQUEST).build())

        val courses = courseService.getStudentsCourses(userId)
        return ResponseEntity.ok(courses)

    }
}


