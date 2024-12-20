package app.web.mymoney.services.impl;

import app.web.mymoney.DTOs.request.category.CategoryRequestDTO;
import app.web.mymoney.DTOs.response.category.CategoryResponseDTO;
import app.web.mymoney.entities.Categories;
import app.web.mymoney.repositories.CategoryRepository;
import app.web.mymoney.services.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    @Override
    public CategoryResponseDTO createCategory(CategoryRequestDTO categoryRequestDTO) {

        Categories category = categoryRequestDTO.toEntity();

        category = categoryRepository.save(category);

        return new CategoryResponseDTO(category);
    }
}
