package net.spring.jpa_fs.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import net.spring.jpa_fs.entities.Role;
import net.spring.jpa_fs.entities.User;
import net.spring.jpa_fs.repositories.RoleRepository;
import net.spring.jpa_fs.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private  UserRepository userRepository;
    private RoleRepository roleRepository;



    @Override
    public User addNewUser(User user) {
        user.setUserId(UUID.randomUUID().toString());
        return userRepository.save(user);
    }

    @Override
    public Role addNewRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public User findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public Role findByRoleName(String roleName) {
        return roleRepository.findByRoleName(roleName);
    }

    @Override
    public void addRoleToUser(String userName, String roleName) {
        User  user =findByUserName(userName);
        Role role =findByRoleName(roleName);
        if(user.getRoles()!=null) {
            user.getRoles().add(role);
            role.getUsers().add(user);
        }


    }

    @Override
    public User authenticate(String userName, String password) {
        User user = userRepository.findByUserName(userName);
        if(user==null)throw new RuntimeException("Invalid username or password");
        if(user.getPassword().equals(password)) {
            return user;
        }
        throw new RuntimeException("Invalid username or password");
    }
}
