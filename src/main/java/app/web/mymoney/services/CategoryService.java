package app.web.mymoney.services;

import app.web.mymoney.DTOs.request.category.CategoryRequestDTO;
import app.web.mymoney.DTOs.response.category.CategoryResponseDTO;

public interface CategoryService {

    CategoryResponseDTO createCategory(CategoryRequestDTO categoryRequestDTO);
}
