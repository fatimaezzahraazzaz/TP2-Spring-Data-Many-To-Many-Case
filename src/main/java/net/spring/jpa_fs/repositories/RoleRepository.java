package net.spring.jpa_fs.repositories;

import net.spring.jpa_fs.entities.Role;
import net.spring.jpa_fs.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByRoleName(String roleName);
}
