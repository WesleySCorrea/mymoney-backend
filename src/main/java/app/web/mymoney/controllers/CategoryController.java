package app.web.mymoney.controllers;

import app.web.mymoney.DTOs.request.CategoryRequestDTO;
import app.web.mymoney.DTOs.response.CategoryResponseDTO;
import app.web.mymoney.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategoryResponseDTO> createCategory(@RequestBody CategoryRequestDTO categoryRequestDTO) {

        CategoryResponseDTO categoryResponseDTO = categoryService.createCategory(
                categoryRequestDTO.getUserId(),
                categoryRequestDTO.getName()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(categoryResponseDTO);
    }
}
