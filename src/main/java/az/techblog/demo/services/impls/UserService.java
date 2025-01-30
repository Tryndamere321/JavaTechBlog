package az.techblog.demo.services.impls;

import az.techblog.demo.dto.userDtos.UserRegisterDto;
import az.techblog.demo.models.UserEntity;

public interface UserService {
    void registerUser(UserRegisterDto userRegisterDto);
    UserEntity findByEmail(String email);
    UserEntity findByUserId(Long id);
}
