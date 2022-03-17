package uz.mafia.jwt_access_refresh_amigo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import uz.mafia.jwt_access_refresh_amigo.domain.Role;
import uz.mafia.jwt_access_refresh_amigo.domain.User;
import uz.mafia.jwt_access_refresh_amigo.service.UserService;

import java.util.ArrayList;

@SpringBootApplication
public class JwtAccessRefreshAmigoApplication {

    public static void main(String[] args) {
        SpringApplication.run(JwtAccessRefreshAmigoApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner runner(UserService userService) {
        return args -> {
            userService.saveRole(new Role(null, "ROLE_USER"));
            userService.saveRole(new Role(null, "ROLE_MANAGER"));
            userService.saveRole(new Role(null, "ROLE_ADMIN"));
            userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

            userService.saveUser(new User(null, "john mafia", "john", "1234", new ArrayList<>()));
            userService.saveUser(new User(null, "will terry", "will", "1234", new ArrayList<>()));
            userService.saveUser(new User(null, "jim john", "jim", "1234", new ArrayList<>()));
            userService.saveUser(new User(null, "arnold masha", "arnold", "1234", new ArrayList<>()));

            userService.addRoleToUser("john", "ROLE_USER");
            userService.addRoleToUser("john", "ROLE_MANAGER");
            userService.addRoleToUser("will", "ROLE_MANAGER");
            userService.addRoleToUser("jim", "ROLE_ADMIN");
            userService.addRoleToUser("arnold", "ROLE_ADMIN");
            userService.addRoleToUser("arnold", "ROLE_SUPER_ADMIN");
            userService.addRoleToUser("arnold", "ROLE_USER");
        };
    }
}
