package course_reg_app.repository

import course_reg_app.models.Department
import org.springframework.data.jpa.repository.JpaRepository

interface DepartmentRepository: JpaRepository<Department, Long> {
}