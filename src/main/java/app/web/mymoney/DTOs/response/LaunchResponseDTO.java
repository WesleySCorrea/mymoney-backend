package app.web.mymoney.DTOs.response;

import app.web.mymoney.entities.Launch;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class LaunchResponseDTO {

    private Long id;
    private String description;
    private BigDecimal amount;
    private String typeMoviment;
    private Long categoryId;
    private Long userId;
    private Long accountId;
    private LocalDate paymentDate;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private Boolean isTransfer;

    public LaunchResponseDTO(Launch launch) {
        this.id = launch.getId();
        this.description = launch.getDescription();
        this.amount = launch.getAmount();
        this.typeMoviment = launch.getTypeMoviment().name();
        this.categoryId = launch.getCategoryId().getId();
        this.userId = launch.getUserId().getId();
        this.accountId = launch.getAccountId().getId();
        this.paymentDate = launch.getPaymentDate();
        this.createdAt = launch.getCreatedAt();
        this.updatedAt = launch.getUpdatedAt();
        this.isTransfer = launch.getIsTransfer();
    }
}
