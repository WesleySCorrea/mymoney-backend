package app.web.mymoney.DTOs.response.transaction;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class BalanceResponseDTO {

    private BigDecimal balance;
    private BigDecimal totalIncomes;
    private BigDecimal totalExpenses;

    public BalanceResponseDTO(Object[] object) {

        this.balance = (object[2] != null) ? new BigDecimal(object[2].toString()) : BigDecimal.ZERO;
        this.totalIncomes = (object[0] != null) ? new BigDecimal(object[0].toString()) : BigDecimal.ZERO;
        this.totalExpenses = (object[1] != null) ? new BigDecimal(object[1].toString()) : BigDecimal.ZERO;
    }
}
