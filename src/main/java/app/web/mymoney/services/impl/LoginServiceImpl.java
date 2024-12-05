package app.web.mymoney.services.impl;

import app.web.mymoney.DTOs.request.LoginRequest;
import app.web.mymoney.DTOs.response.LoginResponse;
import app.web.mymoney.entities.Users;
import app.web.mymoney.repositories.UserRepository;
import app.web.mymoney.services.LoginService;
import app.web.mymoney.services.TokenService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LoginServiceImpl implements LoginService {

    private final TokenService tokenService;
    private final UserRepository userRepository;

    @Override
    public LoginResponse loginService(LoginRequest loginRequest) {

        Users user = this.findUserByUsernameOrEmail(loginRequest.getUsername());

        if (!user.getPassword().equals(loginRequest.getPassword())) {
            throw new IllegalArgumentException("Senha incorreta");
        }

        return this.tokenService.generateAccessToken(user);
    }

    private Users findUserByUsernameOrEmail(String username) {

        Users user =  userRepository.findByUsernameOrEmail(username, username);

        return user;
    }
}