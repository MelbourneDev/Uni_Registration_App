package course_reg_app.models

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "department")
class Department (
    @Id
    @GeneratedValue(strategy = GenerationType. IDENTITY)
    val id: Long? = null,
    val name: String,

    @OneToMany(mappedBy = "department")
    val courses: Set<Course> = HashSet()
)