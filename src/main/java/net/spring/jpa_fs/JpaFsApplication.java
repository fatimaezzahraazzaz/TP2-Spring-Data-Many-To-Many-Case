package net.spring.jpa_fs;

import net.spring.jpa_fs.entities.Role;
import net.spring.jpa_fs.entities.User;
import net.spring.jpa_fs.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class JpaFsApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaFsApplication.class, args);
	}

	@Bean
	CommandLineRunner start(UserService userService) {
		return args -> {
			User u1 = new User();
			u1.setUserName("user1");
			u1.setPassword("12345");
			userService.addNewUser(u1);

			User u2 = new User(); // FIX: was modifying u1 again
			u2.setUserName("admin");
			u2.setPassword("123456");
			userService.addNewUser(u2);

			Stream.of("STUDENT", "USER", "ADMIN").forEach(r -> {
				Role role = new Role();
				role.setRoleName(r);
				userService.addNewRole(role);
			});

			userService.addRoleToUser("user1", "STUDENT");
			userService.addRoleToUser("user1", "USER");
			userService.addRoleToUser("admin", "USER");
			userService.addRoleToUser("admin", "ADMIN");

			try{
				User user=userService.authenticate("user1","12345");
				System.out.println(user.getUserId());
				System.out.println(user.getUserName());
				System.out.println("Roles=>");
				user.getRoles().forEach(r -> {
					System.out.println("Role="+r);
				});
			}
			catch(Exception e){
				e.printStackTrace();

			}

		};
	}
}

