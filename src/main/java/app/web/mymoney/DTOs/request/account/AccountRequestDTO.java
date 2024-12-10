package app.web.mymoney.DTOs.request.account;

import app.web.mymoney.entities.Accounts;
import app.web.mymoney.entities.Users;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class AccountRequestDTO {

    private String name;
    private Long userId;
    private BigDecimal balance = BigDecimal.ZERO;

    public Accounts toEntity() {

        Accounts account = new Accounts();
        Users user = new Users();
        user.setId(this.userId);

        account.setName(this.name);
        account.setUser(user);
        account.setBalance(this.balance);
        return account;
    }

}
