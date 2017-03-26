package infrastructure.service.user;

import domain.entity.user.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * Created by ShchykalauM on 17.02.2017.
 */
public interface IUserService extends UserDetailsService {

    User saveUser(User user);

    List<User> findUsers();

    User findByLogin(String login);

    User updateUser(User user);

    User updateRoles(User user);

    void delete(Long id);

}
