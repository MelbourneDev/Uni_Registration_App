package course_reg_app.models

import javax.persistence.*


@Entity
@Table (name="student")
data class Student(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    val user: User,

    @ManyToOne
    @JoinColumn(name = "department_id")
    val department: Department? = null,


)
