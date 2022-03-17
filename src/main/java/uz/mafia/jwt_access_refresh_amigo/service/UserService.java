package uz.mafia.jwt_access_refresh_amigo.service;

import uz.mafia.jwt_access_refresh_amigo.domain.Role;
import uz.mafia.jwt_access_refresh_amigo.domain.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User> getUsers();
}
