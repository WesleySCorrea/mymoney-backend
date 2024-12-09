package app.web.mymoney.DTOs.request;

import app.web.mymoney.entities.Accounts;
import app.web.mymoney.entities.Categories;
import app.web.mymoney.entities.Launch;
import app.web.mymoney.entities.Users;
import app.web.mymoney.enums.MovementEnum;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class LaunchRequestDTO {

    private String description;
    private BigDecimal amount;
    private String typeMoviment;
    private Long categoryId;
    private Long userId;
    private Long accountId;
    private LocalDate paymentDate;
    private Boolean isTransfer;

    public Launch toEntity() {
        Launch launch = new Launch();

        Categories categories = new Categories();
        categories.setId(categoryId);

        Users users = new Users();
        users.setId(userId);

        Accounts accounts = new Accounts();
        accounts.setId(accountId);

        launch.setDescription(description);
        launch.setAmount(amount);
        launch.setTypeMoviment(MovementEnum.valueOf(typeMoviment));
        launch.setCategoryId(categories);
        launch.setUserId(users);
        launch.setAccountId(accounts);
        launch.setPaymentDate(paymentDate);
        launch.setIsTransfer(isTransfer);

        return launch;
    }
}
