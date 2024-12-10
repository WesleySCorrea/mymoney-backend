package app.web.mymoney.controllers;

import app.web.mymoney.DTOs.request.account.AccountRequestDTO;
import app.web.mymoney.DTOs.response.account.AccountResponseDTO;
import app.web.mymoney.services.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;

    @PostMapping
    public ResponseEntity<AccountResponseDTO> createAccount(@RequestBody AccountRequestDTO accountRequestDTO) {

        AccountResponseDTO accountResponseDTO = accountService.createAccount(
                accountRequestDTO.getName(),
                accountRequestDTO.getUserId(),
                accountRequestDTO.getBalance()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(accountResponseDTO);
    }
}
