package uz.mafia.jwt_access_refresh_amigo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.mafia.jwt_access_refresh_amigo.domain.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
