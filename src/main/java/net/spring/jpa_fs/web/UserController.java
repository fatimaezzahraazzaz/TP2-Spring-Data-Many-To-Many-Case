package net.spring.jpa_fs.web;

import net.spring.jpa_fs.entities.User;
import net.spring.jpa_fs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/users/{username}")
    public User user(@PathVariable String username){
        User user =userService.findByUserName(username);
        return user;


    }

}
