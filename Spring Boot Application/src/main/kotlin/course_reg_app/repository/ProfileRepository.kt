package course_reg_app.repository

import course_reg_app.models.Profile
import org.springframework.data.jpa.repository.JpaRepository

interface ProfileRepository: JpaRepository<Profile, Long > {
}