package az.techblog.demo.dto.articleDtos;

import lombok.Data;

@Data
public class ArticleUpdateDto {
    private Long id;
    private String title;

    private String description;
    private String photoUrl;
    private Long categoryId;
}
