package app.web.mymoney.DTOs.response.transaction;

import app.web.mymoney.entities.Transactions;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class TransactionsResponseDTO {

    private String description;
    private BigDecimal amount;
    private Long userId;
    private Long sourceAccountId;
    private Long destinationAccountId;
    private Boolean isTransfer;

    public TransactionsResponseDTO(Transactions transaction) {
        this.description = transaction.getDescription();
        this.amount = transaction.getAmount();
        this.userId = transaction.getUser().getId();
        this.sourceAccountId = transaction.getSourceAccount().getId();
        this.destinationAccountId = transaction.getDestinationAccount().getId();
        this.isTransfer = transaction.getIsTransfer();
    }
}
