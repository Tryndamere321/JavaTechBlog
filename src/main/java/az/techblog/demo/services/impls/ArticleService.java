package az.techblog.demo.services.impls;

import az.techblog.demo.dto.articleDtos.ArticleCreateDto;
import az.techblog.demo.dto.articleDtos.ArticleDto;
import az.techblog.demo.dto.articleDtos.ArticleUpdateDto;
import az.techblog.demo.models.Article;

import java.util.List;

public interface ArticleService {
    List<ArticleDto> getAllArticles();
    void createArticle(ArticleCreateDto articleCreateDto);
    void updateArticle(ArticleUpdateDto articleUpdateDto);
    void deleteArticle(Long id);
    ArticleDto findUpdateArticle(Long id);


}
