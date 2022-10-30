package spring.app.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.app.application.model.Role;
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName (String name);
}
