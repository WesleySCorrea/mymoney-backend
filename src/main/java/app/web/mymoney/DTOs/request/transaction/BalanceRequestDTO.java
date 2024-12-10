package app.web.mymoney.DTOs.request.transaction;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BalanceRequestDTO {

    @Min(1)
    @Max(12)
    private int month;

    @Min(2020)
    @Max(2050)
    private Integer year;
}
