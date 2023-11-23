package course_reg_app.repository

import course_reg_app.models.Course
import org.springframework.data.jpa.repository.JpaRepository

interface CourseRepository: JpaRepository<Course, String> {
}