package course_reg_app.models

import javax.persistence.*

@Entity
@Table(name="schedule")
data class Schedule(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val Id: Long? = null,

    @ManyToOne
    @JoinColumn(name = "user_id")
    val user: User,

    @ManyToMany
    @JoinTable(
        name = "schedule_courses",
        joinColumns = [JoinColumn(name = "schedule_id")],
        inverseJoinColumns = [JoinColumn(name = "course_code")]
    )
    val courses: Set<Course> = HashSet(),

    val semester: String,

    val year: Int,

)
