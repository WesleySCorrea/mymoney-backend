package app.web.mymoney.services.impl;

import app.web.mymoney.DTOs.request.UserInfoDTO;
import app.web.mymoney.DTOs.response.LoginResponse;
import app.web.mymoney.entities.Users;
import app.web.mymoney.enums.RoleEnum;
import app.web.mymoney.services.TokenService;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Service
@AllArgsConstructor
public class TokenServiceImpl implements TokenService {

//    private static final String SECRET_KEY = "MyMoneySecretyWith32Characters2024";
    private static final String SECRET_KEY = "My-Money-Secrety";
    private static final long EXPIRATION_TIME = 3600000;
    private static final long REFRESH_TOKEN_EXPIRATION_TIME = 36000000;

    public LoginResponse generateAccessToken(Users user) {

        Date expiration = new Date(System.currentTimeMillis() + EXPIRATION_TIME);
        Date expirationRefreshToken = new Date(System.currentTimeMillis() + REFRESH_TOKEN_EXPIRATION_TIME);

        String accessToken = JWT.create()
                .withSubject(user.getUsername())
                .withClaim("id", user.getId())
                .withClaim("name", user.getName())
                .withClaim("email", user.getEmail())
                .withClaim("role", user.getRole().name())
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .sign(Algorithm.HMAC256(SECRET_KEY));

        String refreshToken = this.generateRefreshToken(user, expirationRefreshToken);

        return new LoginResponse(user, accessToken, refreshToken, expiration, expirationRefreshToken);
    }
    public String generateRefreshToken(Users user, Date expirationRefreshToken) {

        return JWT.create()
                .withSubject(user.getUsername())
                .withClaim("id", user.getId())
                .withIssuedAt(new Date())
                .withExpiresAt(expirationRefreshToken)
                .sign(Algorithm.HMAC256(SECRET_KEY));
    }

    public UserInfoDTO validateTokenAndExtractUserInfo(String token) {
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET_KEY))
                    .build();
            DecodedJWT decodedJWT = verifier.verify(token);

            String username = decodedJWT.getSubject();
            Long id = decodedJWT.getClaim("id").asLong();
            String email = decodedJWT.getClaim("email").asString();
            String role = decodedJWT.getClaim("role").asString();

            UserInfoDTO userInfoDTO = new UserInfoDTO();
            userInfoDTO.setId(id);
            userInfoDTO.setUsername(username);
            userInfoDTO.setEmail(email);
            userInfoDTO.setRole(RoleEnum.valueOf(role));

            return userInfoDTO;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao extrair informações do token: " + e.getMessage(), e);
        }
    }

    public void validateToken(String accessToken) {
        try {
            JWT.require(Algorithm.HMAC256(SECRET_KEY))
                    .build()
                    .verify(accessToken);
        } catch (JWTVerificationException e) {
            // Aqui lançamos uma exceção comum para parar a aplicação
            throw new RuntimeException("Token inválido ou expirado: " + e.getMessage(), e);
        }
    }


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