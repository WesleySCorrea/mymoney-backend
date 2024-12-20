package app.web.mymoney.services;

import app.web.mymoney.DTOs.response.account.AccountResponseDTO;

import java.math.BigDecimal;

public interface AccountService {

    AccountResponseDTO createAccount (String name, Long userId, BigDecimal balance);
}
