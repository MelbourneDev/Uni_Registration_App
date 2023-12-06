package course_reg_app.service


import course_reg_app.models.DepartmentName
import course_reg_app.repository.CourseRepository
import org.springframework.stereotype.Service


@Service
class CourseService(
    private val courseRepository: CourseRepository
) {
    fun getStudentsCourses(userId: Long): List<String> {

        val courses = courseRepository.findCoursesByStudentUserId(userId)
        return courses.map { it.title }
    }
}
