package az.techblog.demo.services;

import az.techblog.demo.dto.articleDtos.ArticleDto;
import az.techblog.demo.models.Article;
import az.techblog.demo.repositories.ArticleRepository;
import az.techblog.demo.services.impls.ArticleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticleServiceImpl implements ArticleService {
    private final ModelMapper modelMapper;
    private final ArticleRepository articleRepository;

    @Autowired
     public ArticleServiceImpl(ArticleRepository articleRepository, ModelMapper modelMapper) {
        this.articleRepository = articleRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ArticleDto> getAllArticles() {

        List<Article> articles = articleRepository.findAll();
        List<ArticleDto> result = articles.stream().map(article-> modelMapper.map(article,ArticleDto.class)).collect(Collectors.toList());
        return result;
    }
}
