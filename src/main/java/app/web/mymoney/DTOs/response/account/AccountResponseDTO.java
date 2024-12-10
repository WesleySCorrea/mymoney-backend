package app.web.mymoney.DTOs.response.account;

import app.web.mymoney.entities.Accounts;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class AccountResponseDTO {

    private Long id;
    private String name;
    private BigDecimal balance;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private Long userId;

    public AccountResponseDTO(Accounts account) {
        this.id = account.getId();
        this.name = account.getName();
        this.balance = account.getBalance();
        this.createdAt = account.getCreatedAt();
        this.updatedAt = account.getUpdatedAt();
        this.userId = account.getUser().getId();
    }
}
