package course_reg_app.models

import javax.persistence.*

@Entity
@Table(name = "user")
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false, unique = true)
    val username: String,

    @Column(nullable = false)
    val password: String,

    @Column(nullable = false, unique = true)
    val email: String,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    val role: UserRole,

    @OneToOne(mappedBy = "user")
    val profile: Profile? = null,

    @OneToMany(mappedBy = "user")
    val schedules: Set<Schedule> = HashSet()
)

enum class UserRole {
    ADMIN, TUTOR, STUDENT
}
