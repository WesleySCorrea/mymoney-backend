package app.web.mymoney.DTOs.request;

import app.web.mymoney.entities.Accounts;
import app.web.mymoney.entities.Transactions;
import app.web.mymoney.entities.Users;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class TransactionsRequestDTO {

    @NotBlank(message = "Description is required.")
    private String description;

    @NotBlank(message = "Description is required.")
    private BigDecimal amount;

    @NotBlank(message = "User is required.")
    private Long userId;

    @NotBlank(message = "Source account is required.")
    private Long sourceAccountId;

    @NotBlank(message = "Destination account is required.")
    private Long destinationAccountId;

    @NotBlank(message = "Field is required.")
    private Boolean isTransfer;

    public Transactions toEntity() {
        Transactions transaction = new Transactions();

        Users user = new Users();
        user.setId(userId);

        Accounts sourceAccount = new Accounts();
        sourceAccount.setId(sourceAccountId);

       Accounts destinationAccount = new Accounts();
       destinationAccount.setId(destinationAccountId);

        transaction.setDescription(description);
        transaction.setAmount(amount);
        transaction.setUser(user);
        transaction.setSourceAccount(sourceAccount);
        transaction.setDestinationAccount(destinationAccount);
        transaction.setIsTransfer(isTransfer);

        return transaction;
    }
}
