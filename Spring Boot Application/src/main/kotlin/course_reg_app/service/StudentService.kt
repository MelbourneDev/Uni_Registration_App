package course_reg_app.service

import course_reg_app.repository.StudentRepository
import org.springframework.stereotype.Service

@Service
class StudentService(private val studentRepository: StudentRepository) {

    fun getDepartmentNameByUserId(userId: Long): String? {
        val student = studentRepository.findByUserId(userId)
        return student?.department?.name.toString()
    }

}
