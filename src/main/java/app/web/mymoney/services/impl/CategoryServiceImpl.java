package app.web.mymoney.services.impl;

import app.web.mymoney.DTOs.response.CategoryResponseDTO;
import app.web.mymoney.entities.Categories;
import app.web.mymoney.entities.Users;
import app.web.mymoney.repositories.CategoryRepository;
import app.web.mymoney.services.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    @Override
    public CategoryResponseDTO createCategory(Long userId, String name) {

        Categories category = new Categories();
        Users user = new Users();
        user.setId(userId);

        category.setName(name);
        category.setUser(user);

        category = categoryRepository.save(category);

        return new CategoryResponseDTO(category);
    }
}
