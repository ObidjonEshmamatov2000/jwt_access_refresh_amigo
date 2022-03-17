package uz.mafia.jwt_access_refresh_amigo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.mafia.jwt_access_refresh_amigo.domain.Role;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
