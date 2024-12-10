package app.web.mymoney.DTOs.request.category;

import app.web.mymoney.entities.Categories;
import app.web.mymoney.entities.Users;
import app.web.mymoney.enums.MovementEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryRequestDTO {

    private String name;
    private String typeCategory;
    private Long userId;

    public Categories toEntity() {
        Categories category = new Categories();
        Users user = new Users();
        user.setId(userId);

        category.setName(name);
        category.setTypeCategory(MovementEnum.valueOf(typeCategory));
        category.setUser(user);
        return category;
    }
}
