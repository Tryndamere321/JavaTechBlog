package az.techblog.demo.controllers;

import az.techblog.demo.dto.CategoryDto;
import az.techblog.demo.services.impls.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    private final CategoryService categoryService;

    public HomeController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @GetMapping("/")
    public String home(Model model){
        List<CategoryDto> cat=categoryService.findAllCategories();
        model.addAttribute("categories",cat);
        return "home";
    }
}
