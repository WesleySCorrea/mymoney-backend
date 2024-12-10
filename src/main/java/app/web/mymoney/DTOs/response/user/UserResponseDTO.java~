package app.web.mymoney.DTOs.response;

import app.web.mymoney.entities.Users;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDTO {

    private Long id;
    private String name;
    private String surname;
    private String username;
    private String email;
    private String createdAt;

    public UserResponseDTO(Users user) {
        this.id = user.getId();
        this.name = user.getName();
        this.surname = user.getSurname();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.createdAt = user.getCreatedAt().toString();
    }
}
