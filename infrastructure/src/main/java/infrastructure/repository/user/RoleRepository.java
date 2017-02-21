package infrastructure.repository.user;

import domain.entity.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by ShchykalauM on 21.02.2017.
 */
public interface RoleRepository extends JpaRepository<Role, Long> {
}
