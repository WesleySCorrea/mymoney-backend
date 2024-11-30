package app.web.mymoney.services;

import app.web.mymoney.DTOs.response.CategoryResponseDTO;

public interface CategoryService {

    CategoryResponseDTO createCategory(Long userId, String name);
}
