package course_reg_app.repository

import course_reg_app.models.AdminActions
import org.springframework.data.jpa.repository.JpaRepository

interface AdminActionsRepository: JpaRepository<AdminActions, Long> {
}