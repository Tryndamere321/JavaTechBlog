package az.techblog.demo.services;

import az.techblog.demo.dto.userDtos.UserRegisterDto;
import az.techblog.demo.models.Role;
import az.techblog.demo.models.UserEntity;
import az.techblog.demo.repositories.RoleRepository;
import az.techblog.demo.repositories.UserRepository;
import az.techblog.demo.services.impls.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder encoder;
    private final ModelMapper modelMapper;


    @Override
    public void registerUser(UserRegisterDto userRegisterDto) {
        UserEntity user = userRepository.findByEmail(userRegisterDto.getEmail());
        if (user != null) {
            throw new UsernameNotFoundException("Bele istifadeci var");
        } else {
            UserEntity userEntity = modelMapper.map(userRegisterDto, UserEntity.class);
            userEntity.setPassword(encoder.encode(userRegisterDto.getPassword()));
            Role role = RoleRepository.findByName("ROLE_USER");
            userEntity.setRoles(Collections.singletonList(role));
            userRepository.save(userEntity);
        }
    }

    @Override
    public UserEntity findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public UserEntity findByUserId(Long id) {
        return userRepository.findById(id).orElseThrow();
    }
}
