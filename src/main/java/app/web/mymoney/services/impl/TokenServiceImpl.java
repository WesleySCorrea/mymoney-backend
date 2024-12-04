package app.web.mymoney.services.impl;

import app.web.mymoney.DTOs.response.LoginResponse;
import app.web.mymoney.entities.Users;
import app.web.mymoney.services.TokenService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Service
@AllArgsConstructor
public class TokenServiceImpl implements TokenService {

    private static final String SECRET_KEY = "MyMoneySecretyWith32Characters2024";
    private static final long EXPIRATION_TIME = 3600 * 1000;
    private static final long REFRESH_TOKEN_EXPIRATION_TIME = 10 * 3600 * 1000;
    private final Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));

    public LoginResponse generateAccessToken(Users user) {

        Date expiration = new Date(System.currentTimeMillis() + EXPIRATION_TIME);
        Date expirationRefreshToken = new Date(System.currentTimeMillis() + REFRESH_TOKEN_EXPIRATION_TIME);
        Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));


        String accessToken = Jwts.builder()
                .setSubject(user.getUsername())
                .claim("id", user.getId())
                .claim("name", user.getName())
                .claim("email", user.getEmail())
                .claim("role", user.getRole())
                .setIssuedAt(new Date())
                .setExpiration(expiration)
                .signWith(key,SignatureAlgorithm.HS256)
                .compact();

        String refreshToken = this.generateRefreshToken(user, expirationRefreshToken, key);

        return new LoginResponse(user, accessToken, refreshToken, expiration, expirationRefreshToken);
    }
    public String generateRefreshToken(Users username, Date expirationRefreshToken, Key key) {
        return Jwts.builder()
                .setSubject(username.getSurname())
                .claim("id", username.getId())
                .setIssuedAt(new Date())
                .setExpiration(expirationRefreshToken)
                .signWith(key,SignatureAlgorithm.HS256)
                .compact();
    }

//    // Método para validar um token JWT
//    public boolean validateToken(String token) {
//        try {
//            Jwts.parser()
//                    .setSigningKey(SECRET_KEY)
//                    .parseClaimsJws(token);
//            return true; // Se não lançar exceção, o token é válido
//        } catch (JwtException | IllegalArgumentException e) {
//            // Se houver erro de parsing ou o token for inválido
//            return false;
//        }
//    }
//
//    // Método para extrair o username ou email do token
//    public String extractUsernameOrEmail(String token) {
//        return Jwts.parser()
//                .setSigningKey(SECRET_KEY)
//                .parseClaimsJws(token)
//                .getBody()
//                .getSubject();
//    }
//
//    // Método para verificar se o token está expirado
//    public boolean isTokenExpired(String token) {
//        Date expiration = Jwts.parser()
//                .setSigningKey(SECRET_KEY)
//                .parseClaimsJws(token)
//                .getBody()
//                .getExpiration();
//        return expiration.before(new Date());
//    }
}
