package course_reg_app.models

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table (name = "admin_actions")
data class AdminActions(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @ManyToOne
    @JoinColumn(name = "admin_Id")
    val admin: User,

    @Enumerated(EnumType.STRING)
    val actionType: AdminActionType,

    val details: String,

    val timestamp: LocalDateTime = LocalDateTime.now()

)

enum class AdminActionType {
    SCHEDULE_UPDATE, COURSE_UPDATE, USER_UPDATE
}
