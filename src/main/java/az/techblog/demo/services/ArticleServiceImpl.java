package az.techblog.demo.services;

import az.techblog.demo.dto.articleDtos.ArticleCreateDto;
import az.techblog.demo.dto.articleDtos.ArticleDto;
import az.techblog.demo.dto.articleDtos.ArticleUpdateDto;
import az.techblog.demo.models.Article;
import az.techblog.demo.models.Category;
import az.techblog.demo.repositories.ArticleRepository;
import az.techblog.demo.services.impls.ArticleService;
import az.techblog.demo.services.impls.CategoryService;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ArticleServiceImpl implements ArticleService {
    private final ModelMapper modelMapper;
    private final ArticleRepository articleRepository;
    private final CategoryService categoryService;
    private final Cloudinary cloudinary;

    @Autowired
     public ArticleServiceImpl(ArticleRepository articleRepository, ModelMapper modelMapper, CategoryService categoryService, Cloudinary cloudinary) {
        this.articleRepository = articleRepository;
        this.modelMapper = modelMapper;
        this.categoryService = categoryService;
        this.cloudinary = cloudinary;
    }

    @Override
    public List<ArticleDto> getAllArticles() {

        List<Article> articles = articleRepository.findAll();
        List<ArticleDto> result = articles.stream().map(article-> modelMapper.map(article,ArticleDto.class)).collect(Collectors.toList());
        return result;
    }

    @Override
    public void createArticle(ArticleCreateDto articleDto) {
        Category findCategory=categoryService.findCategoryById(articleDto.getCategoryId());
        Article article=new Article();
        article.setCategory(findCategory);
        article.setTitle(articleDto.getTitle());
        article.setDescription(articleDto.getDescription());
        articleRepository.save(article);
    }


    @Override
    public void updateArticle(ArticleUpdateDto articleUpdateDto) {
        Category findCategory=categoryService.findCategoryById(articleUpdateDto.getId());
        Article article=articleRepository.findById(articleUpdateDto.getId()).orElseThrow();
        article.setTitle(articleUpdateDto.getTitle());
        article.setDescription(articleUpdateDto.getDescription());
        article.setCategory(findCategory);
        articleRepository.save(article);

    }

    @Override
    public void deleteArticle(Long id) {
      articleRepository.deleteById(id);
    }

    @Override
    public ArticleDto findUpdateArticle(Long id) {
        Article article=articleRepository.findById(id).orElseThrow();
        return modelMapper.map(article,ArticleDto.class);
    }
}
