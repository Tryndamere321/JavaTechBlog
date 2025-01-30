package az.techblog.demo.services;

import az.techblog.demo.dto.categoryDtos.CategoryCreateDto;
import az.techblog.demo.dto.categoryDtos.CategoryDto;
import az.techblog.demo.dto.categoryDtos.CategoryUpdateDto;
import az.techblog.demo.models.Category;
import az.techblog.demo.repositories.CategoryRepository;
import az.techblog.demo.services.impls.CategoryService;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service


public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public List<CategoryDto> findAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        List<CategoryDto> result = categories
                .stream()
                .map(x -> modelMapper
                        .map(x, CategoryDto.class))
                .toList();   //List<Category> -> x -> CategoryDto -> List<CategoryDto>

        return result;
    }

    @Override
    public void createCategory(CategoryCreateDto categoryCreateDto) {
        Category category = new Category();
        category.setName(categoryCreateDto.getName());
        categoryRepository.save(category);

    }

    @Override
    public void updateCategory(CategoryUpdateDto categoryUpdateDto) {
        Category findCategory=categoryRepository.findById(categoryUpdateDto.getId()).orElseThrow();
        findCategory.setName(categoryUpdateDto.getName());
        categoryRepository.save(findCategory);

    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);

    }

    @Override
    public CategoryUpdateDto findUpdateCategory(Long id) {
        Category category=categoryRepository.findById(id).orElseThrow();
        return modelMapper.map(category,CategoryUpdateDto.class);
    }

    @Override
    public Category findCategoryById(Long id) {
        return categoryRepository.findById(id).orElseThrow();
    }


}
