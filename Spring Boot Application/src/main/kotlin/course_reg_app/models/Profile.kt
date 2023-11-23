package course_reg_app.models

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "profile")
class Profile(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val firstName: String,
    val lastName: String,
    val dateOfBirth: Date,
    val gender: String,
    val contactNumber: String,
    val address: String,

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    val user: User? = null
)
