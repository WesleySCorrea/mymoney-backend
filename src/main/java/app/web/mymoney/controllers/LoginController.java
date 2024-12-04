package app.web.mymoney.controllers;

import app.web.mymoney.DTOs.request.LoginRequest;
import app.web.mymoney.DTOs.response.LoginResponse;
import app.web.mymoney.services.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @GetMapping
    public String loginn() {
        return "login";
    }

    @PostMapping
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {

        LoginResponse loginResponse = loginService.loginService(loginRequest);

        return ResponseEntity.ok(loginResponse);
    }
}
