package course_reg_app.service

import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.util.*

@Service
class JwTService {
    private val logger = LoggerFactory.getLogger(JwTService::class.java)
    private val secretKey =  Keys.secretKeyFor(SignatureAlgorithm.HS512)

    fun generateToken(username: String, userId: Long): String {
        val expirationTime = 24 * 60 * 60 * 1000 // 24 hours in milliseconds
        return Jwts.builder()
            .setSubject(username)
            .setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis() + expirationTime))
            .signWith(SignatureAlgorithm.HS512, secretKey)
            .claim("userId", userId)
            .compact()
    }

    fun getUserIdFromToken(token: String): Long? {
        return try {
            val strippedToken = token.replace("Bearer ", "") // Remove Bearer prefix if present
            val claims = Jwts.parser()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(strippedToken)
                .body
            val userId = claims["userId"]
            when (userId) {
                is Int -> userId.toLong()
                is Long -> userId
                else -> null
            }
        } catch (e: Exception) {
            // Log the exception or handle it as needed
            null
        }
    }
}