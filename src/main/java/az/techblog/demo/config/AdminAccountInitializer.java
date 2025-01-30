package az.techblog.demo.config;


import az.techblog.demo.models.Role;
import az.techblog.demo.models.UserEntity;
import az.techblog.demo.repositories.RoleRepository;
import az.techblog.demo.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;

@Configuration
public class AdminAccountInitializer {

    @Bean
    CommandLineRunner initAdminAccount(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            Role adminRole = RoleRepository.findByName("ROLE_ADMIN");
            if (adminRole == null) {
                adminRole = new Role();
                adminRole.setName("ROLE_ADMIN");
                roleRepository.save(adminRole);
            }

            if (userRepository.findByEmail("admin@ferid.com") == null) {
                UserEntity admin = new UserEntity();
                admin.setFirstName("Eli");
                admin.setLastName("Memmedli");
                admin.setEmail("admin@ferid.com");
                admin.setPassword(passwordEncoder.encode("eli123"));
                admin.setRoles(Collections.singletonList(adminRole));
                userRepository.save(admin);
            }
        };
    }
}
