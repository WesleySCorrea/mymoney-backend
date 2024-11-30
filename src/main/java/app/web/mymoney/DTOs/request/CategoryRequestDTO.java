package app.web.mymoney.DTOs.request;

import app.web.mymoney.entities.Categories;
import app.web.mymoney.entities.Users;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryRequestDTO {

    private String name;
    private Long userId;

    public Categories toEntity() {
        Categories category = new Categories();
        Users user = new Users();
        user.setId(userId);

        category.setName(name);
        category.setUser(user);
        return category;
    }
}
