package app.web.mymoney.DTOs.response;

import app.web.mymoney.entities.Categories;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CategoryResponseDTO {

    private Long id;
    private String name;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private Long userId;

    public CategoryResponseDTO(Categories category) {

        this.id = category.getId();
        this.name = category.getName();
        this.createdAt = category.getCreatedAt();
        this.updatedAt = category.getUpdatedAt();
        this.userId = category.getUser().getId();
    }
}
