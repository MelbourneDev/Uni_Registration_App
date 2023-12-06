package course_reg_app.repository

import course_reg_app.models.Course
import course_reg_app.models.DepartmentName
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface CourseRepository: JpaRepository<Course, String> {
    @Query("SELECT c FROM Course c WHERE c.department.id = (SELECT s.department.id FROM Student s WHERE s.user.id = :userId)")
    fun findCoursesByStudentUserId(userId: Long): List<Course>
}
