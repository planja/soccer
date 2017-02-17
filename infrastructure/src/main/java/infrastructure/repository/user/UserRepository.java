package infrastructure.repository.user;

import domain.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by ShchykalauM on 17.02.2017.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findByLogin(String name);
}