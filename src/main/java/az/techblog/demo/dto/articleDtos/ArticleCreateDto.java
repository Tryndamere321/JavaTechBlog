package az.techblog.demo.dto.articleDtos;

import lombok.Data;

@Data
public class ArticleCreateDto {
    private Long categoryId;
    private String title;
    private String description;
    private String photoUrl;

}
