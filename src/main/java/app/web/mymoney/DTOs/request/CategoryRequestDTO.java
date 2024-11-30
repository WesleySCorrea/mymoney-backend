package app.web.mymoney.DTOs.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryRequestDTO {

    private String name;
    private Long userId;
}
