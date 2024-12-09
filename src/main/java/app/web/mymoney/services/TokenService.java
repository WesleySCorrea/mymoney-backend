package app.web.mymoney.services;

import app.web.mymoney.DTOs.request.UserInfoDTO;
import app.web.mymoney.DTOs.response.LoginResponse;
import app.web.mymoney.entities.Users;

public interface TokenService {
    LoginResponse generateAccessToken(Users user);
    UserInfoDTO validateTokenAndExtractUserInfo(String token);
    String validateRefreshTokenAndExtractUserName(String token);

}
