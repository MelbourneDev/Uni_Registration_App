package course_reg_app.models

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "department")
class Department (
    @Id
    @GeneratedValue(strategy = GenerationType. IDENTITY)
    val id: Long? = null,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    val name: DepartmentName,

    @OneToMany(mappedBy = "department")
    val courses: Set<Course> = HashSet()
)

enum class DepartmentName{
    Engineering, IT, Sciences, Law
}