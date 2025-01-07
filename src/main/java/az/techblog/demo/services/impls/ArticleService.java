package az.techblog.demo.services.impls;

import az.techblog.demo.dto.articleDtos.ArticleDto;
import az.techblog.demo.models.Article;

import java.util.List;

public interface ArticleService {
    List<ArticleDto> getAllArticles();

}
