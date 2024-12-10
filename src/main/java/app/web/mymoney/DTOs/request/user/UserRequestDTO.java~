package app.web.mymoney.DTOs.request;

import app.web.mymoney.entities.Users;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDTO {

    @NotBlank(message = "Name is required.")
    @Size(min = 5, max = 50, message = "Name must be between 5 and 50 characters.")
    private String name;

    @Size(min = 5, max = 50, message = "Surname must be between 5 and 50 characters.")
    private String surname;

    @NotBlank(message = "Username is required.")
    @Size(min = 5, max = 50, message = "Username must be between 5 and 50 characters.")
    private String username;

    @NotBlank(message = "Email is required.")
    @Email(message = "Email is not valid.")
    private String email;

    @NotBlank(message = "Password is required.")
    @Size(min = 8, message = "Password must be at least 8 characters long.")
    private String password;

    public Users toEntity() {
        Users user = new Users();
        user.setName(name);
        user.setSurname(surname);
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        return user;
    }
}
