package app.web.mymoney.DTOs.response;

import app.web.mymoney.entities.Users;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDTO {

    private String name;

    private String surname;

    private String email;

    private String createdAt;

    public UserResponseDTO(Users user) {
        this.name = user.getName();
        this.surname = user.getSurname();
        this.email = user.getEmail();
        this.createdAt = user.getCreatedAt().toString();
    }
}
