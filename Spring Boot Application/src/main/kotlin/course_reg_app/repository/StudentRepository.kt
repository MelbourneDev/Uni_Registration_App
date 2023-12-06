package course_reg_app.repository

import course_reg_app.models.Student
import course_reg_app.models.User
import org.springframework.data.jpa.repository.JpaRepository

interface StudentRepository: JpaRepository<Student, Long> {
    fun findByUserId(userId: Long): Student?
}
