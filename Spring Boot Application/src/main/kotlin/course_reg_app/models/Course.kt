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

    @ManyToOne
    @JoinColumn(name = "department_id")
    val department: Department,

    @ManyToOne
    @JoinColumn(name = "tutor_id", nullable = true)
    val tutor_id: User?,


    @ManyToOne
    @JoinColumn(name = "assigned_professor_name", nullable = true)
    val tutor: Tutor?

)
