package app.web.mymoney.DTOs.response.login;

import app.web.mymoney.entities.Users;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class LoginResponse {

    private String accessToken;
    private String refreshToken;
    private String tokenType = "Bearer";
    private Long userId;
    private String username;
    private String role;
    private Long accessTokenExpiresIn;
    private Long refreshTokenExpiresIn;

    public LoginResponse(Users user, String accessToken, String refreshToken, Date accessTokenExpiresIn, Date refreshTokenExpiresIn) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.userId = user.getId();
        this.username = user.getUsername();
        this.role = user.getRole().toString();
        this.accessTokenExpiresIn = accessTokenExpiresIn.getTime()/1000;
        this.refreshTokenExpiresIn = refreshTokenExpiresIn.getTime()/1000;
    }
}
