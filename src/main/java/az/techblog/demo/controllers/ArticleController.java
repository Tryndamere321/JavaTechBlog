package az.techblog.demo.controllers;

import az.techblog.demo.dto.articleDtos.ArticleCreateDto;
import az.techblog.demo.dto.articleDtos.ArticleUpdateDto;
import az.techblog.demo.services.impls.ArticleService;
import az.techblog.demo.services.impls.CategoryService;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleService articleService;
    private final CategoryService categoryService;
    private final Cloudinary cloudinary;

    @GetMapping("/dashboard/article")
    public String article(Model model) {
        model.addAttribute("articles", articleService.getAllArticles());
        return "admin/article/index";
    }

    @GetMapping("/dashboard/article/create")
    public String create(Model model) {
        model.addAttribute("categories", categoryService.findAllCategories());
        return "admin/article/create";
    }

    @PostMapping("/dashboard/article/create")
    public String create(ArticleCreateDto t, @RequestParam("image") MultipartFile file) throws IOException {
        Map<String, Object> uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
        t.setPhotoUrl((String) uploadResult.get("url"));
        articleService.createArticle(t);
        return "redirect:/dashboard/article";
    }

    @GetMapping("/dashboard/article/update/{id}")
    public String update(@PathVariable Long id, Model model) {
        model.addAttribute("categories", categoryService.findAllCategories());
        model.addAttribute("article", articleService.findUpdateArticle(id));
        return "admin/article/update";
    }

    @PostMapping("/dashboard/article/update/{id}")
    public String update(@PathVariable Long id, ArticleUpdateDto articleUpdateDto) {
        articleService.updateArticle(articleUpdateDto);
        return "redirect:/dashboard/article";
    }

    @GetMapping("/dashboard/article/delete/{id}")
    public String delete(@PathVariable Long id) {
        return "admin/article/delete";
    }

    @PostMapping("/dashboard/article/delete/{id}")
    public String remove(@PathVariable Long id) {
        articleService.deleteArticle(id);
        return "redirect:/dashboard/article";
    }
}
