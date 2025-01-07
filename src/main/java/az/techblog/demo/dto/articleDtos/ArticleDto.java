package az.techblog.demo.dto.articleDtos;

import az.techblog.demo.dto.categoryDtos.CategoryDto;
import lombok.Data;

@Data
public class ArticleDto {
    private Long id;
    private String title;
    private String description;
    private String photoUrl;
    private CategoryDto category;

}
