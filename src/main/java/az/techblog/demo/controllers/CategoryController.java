package az.techblog.demo.controllers;

import az.techblog.demo.dto.categoryDtos.CategoryCreateDto;
import az.techblog.demo.dto.categoryDtos.CategoryUpdateDto;
import az.techblog.demo.services.impls.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller

public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/dashboard/category")
    public String index(Model model) {
        model.addAttribute("categories", categoryService.findAllCategories());
        return "admin/category/index";
    }

    @GetMapping("/dashboard/category/create")
    public String create() {
        return "admin/category/create";
    }

    @PostMapping("/dashboard/category/create")
    public String create(CategoryCreateDto categoryCreateDto) {
        categoryService.createCategory(categoryCreateDto);
        return "redirect:/dashboard/category";
    }

    @GetMapping("/dashboard/category/delete/{id}")
    public String delete(@PathVariable Long id) {
        return "admin/category/delete";
    }

    @PostMapping("/dashboard/category/delete/{id}")
    public String remove(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return "redirect:/dashboard/category";
    }

    @GetMapping("/dashboard/category/update/{id}")
    public String update(@PathVariable Long id, Model model) {
        model.addAttribute("category", categoryService.findUpdateCategory(id));
        return "admin/category/update";
    }

    @PostMapping("/dashboard/category/update/{id}")
    public String update(@PathVariable Long id, CategoryUpdateDto categoryUpdateDto) {
        categoryService.updateCategory(categoryUpdateDto);
        return "redirect:/dashboard/category";
    }

}
