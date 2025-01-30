package az.techblog.demo.dto.userDtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserRegisterDto {
    @NotBlank(message = "firstName cannot be null")
    private String firstName;
    @NotBlank(message = "lastName cannot be null")
    private String lastName;
    @NotBlank(message = "Your name is hetempasa")
    private String email;
    @NotBlank(message = "Ne yazirsiz yazin")
    private String password;
    private Long roleId;
}
