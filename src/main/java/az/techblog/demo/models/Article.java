package az.techblog.demo.models;

import jakarta.persistence.*;
import lombok.Data;



@Entity
@Data
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String photoUrl;

    @ManyToOne
    private Category category;



}
