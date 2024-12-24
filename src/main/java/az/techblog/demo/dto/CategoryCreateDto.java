package az.techblog.demo.dto;

import lombok.Data;


public class CategoryCreateDto {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
}
