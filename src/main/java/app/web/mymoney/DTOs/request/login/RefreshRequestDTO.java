package app.web.mymoney.DTOs.request.login;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RefreshRequestDTO {
    private String refreshToken;
}
