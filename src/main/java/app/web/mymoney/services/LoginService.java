package app.web.mymoney.services;

import app.web.mymoney.DTOs.request.login.LoginRequest;
import app.web.mymoney.DTOs.request.login.RefreshRequestDTO;
import app.web.mymoney.DTOs.response.login.LoginResponse;

public interface LoginService {

    LoginResponse login(LoginRequest loginRequest);
    LoginResponse loginWithRefresh(RefreshRequestDTO refreshToken);
}
