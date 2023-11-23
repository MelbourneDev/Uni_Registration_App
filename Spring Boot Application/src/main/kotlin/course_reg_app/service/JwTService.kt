package course_reg_app.service

import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import org.springframework.stereotype.Service
import java.util.*

@Service
class JwTService {

    private val secretKey =  Keys.secretKeyFor(SignatureAlgorithm.HS512)

    fun generateToken(username: String): String {
        val expirationTime = 24 * 60 * 60 * 1000 // 24 hours in milliseconds
        return Jwts.builder()
            .setSubject(username)
            .setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis() + expirationTime))
            .signWith(SignatureAlgorithm.HS512, secretKey)
            .compact()


    }
}