package az.techblog.demo.controllers;

import az.techblog.demo.dto.articleDtos.ArticleDto;
import az.techblog.demo.dto.categoryDtos.CategoryDto;
import az.techblog.demo.services.impls.ArticleService;
import az.techblog.demo.services.impls.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    private final CategoryService categoryService;
    private final ArticleService articleService;

    public HomeController(CategoryService categoryService, ArticleService articleService) {
        this.categoryService = categoryService;
        this.articleService = articleService;
    }


    @GetMapping("/")
    public String home(Model model){
        List<CategoryDto> cat=categoryService.findAllCategories();
        model.addAttribute("categories",cat);
        List<ArticleDto> art=articleService.getAllArticles();
        model.addAttribute("articles",art);

        return "home";
    }
}
