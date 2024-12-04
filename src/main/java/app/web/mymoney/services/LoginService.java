package app.web.mymoney.services;

import app.web.mymoney.DTOs.request.LoginRequest;
import app.web.mymoney.DTOs.response.LoginResponse;

public interface LoginService {

    LoginResponse loginService(LoginRequest loginRequest);
}
