package app.web.mymoney.DTOs.request;

import app.web.mymoney.enums.RoleEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInfoDTO {

    private Long id;
    private String username;
    private String email;
    private RoleEnum role;

}
