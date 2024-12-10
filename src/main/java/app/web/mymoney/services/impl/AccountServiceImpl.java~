package app.web.mymoney.services.impl;

import app.web.mymoney.DTOs.response.AccountResponseDTO;
import app.web.mymoney.entities.Accounts;
import app.web.mymoney.entities.Users;
import app.web.mymoney.repositories.AccountRepository;
import app.web.mymoney.services.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    @Override
    public AccountResponseDTO createAccount(String name, Long userId, BigDecimal balance) {

        Accounts account = new Accounts();
        Users user = new Users();
        user.setId(userId);

        account.setName(name);
        account.setUser(user);
        account.setBalance(balance);

        account =accountRepository.save(account);

        return new AccountResponseDTO(account);
    }
}
