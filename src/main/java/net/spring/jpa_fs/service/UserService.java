package net.spring.jpa_fs.service;

import net.spring.jpa_fs.entities.Role;
import net.spring.jpa_fs.entities.User;

public interface UserService {
    User addNewUser(User user);
    Role addNewRole(Role role);
    User findByUserName(String userName);
    Role findByRoleName(String roleName);
    void addRoleToUser(String username, String roleName);
    User authenticate(String userName, String password);
}
