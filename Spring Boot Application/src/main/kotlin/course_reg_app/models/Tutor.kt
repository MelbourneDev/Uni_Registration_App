package course_reg_app.models

import javax.persistence.*


@Entity
@Table(name="tutor")
data class Tutor(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    val user: User,

    @ManyToOne
    @JoinColumn(name = "department_id")
    val department: Department,


)
