package course_reg_app.models

import javax.persistence.*

@Entity
@Table (name = "course")
class Course(
    @Id
    val courseCode: String,
    val title: String,
    val description: String,
    val credits: Int,
    val tutor: String,

    @ManyToOne
    @JoinColumn(name = "department_id")
    val department: Department,

    @ManyToOne
    @JoinColumn(name = "assigned_professor_id")
    val assignedProfessor: User

)
