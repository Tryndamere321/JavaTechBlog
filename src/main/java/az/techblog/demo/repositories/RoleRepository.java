package az.techblog.demo.repositories;

import az.techblog.demo.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    static Role findByName(String name){
     Role role = new Role();
     role.setName(name);
     return role;
    }
}
