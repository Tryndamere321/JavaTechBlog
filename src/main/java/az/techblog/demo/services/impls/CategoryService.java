package az.techblog.demo.services.impls;

import az.techblog.demo.dto.categoryDtos.CategoryCreateDto;
import az.techblog.demo.dto.categoryDtos.CategoryDto;
import az.techblog.demo.dto.categoryDtos.CategoryUpdateDto;

import java.util.List;

public interface CategoryService {
    List<CategoryDto> findAllCategories();

    void createCategory(CategoryCreateDto categoryCreateDto);
    void updateCategory(CategoryUpdateDto categoryUpdateDto);
    void deleteCategory(Long id);
    CategoryUpdateDto findUpdateCategory(Long id);



}
