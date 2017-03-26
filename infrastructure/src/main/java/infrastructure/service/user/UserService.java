package infrastructure.service.user;

import domain.entity.user.User;
import infrastructure.repository.user.RoleRepository;
import infrastructure.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ShchykalauM on 17.02.2017.
 */

@Service
public class UserService implements IUserService, UserDetailsService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userRepository.findByLogin(login);
        if (user == null) {
            throw new UsernameNotFoundException("User " + login + " was not found in the database");
        }
        List<GrantedAuthority> grantList = user.getRoles().stream().map(o -> new SimpleGrantedAuthority("ROLE_" + o.getRoleName())).collect(Collectors.toList());
        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), grantList);
    }

    @Override
    public User saveUser(User user) {
        User savedUser = userRepository.save(user);
        UserDetails userDetails = this.loadUserByUsername(user.getLogin());
        SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(
                userDetails, user.getPassword(), userDetails.getAuthorities()));
        return savedUser;
    }


    @Override
    public List<User> findUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public User updateUser(User user) {
        User updatedUser = userRepository.findOne(user.getId());
        updatedUser.setImage(user.getImage());
        updatedUser.setPassword(user.getPassword());
        updatedUser.setMail(user.getMail());
        updatedUser.setLogin(user.getLogin());
        updatedUser.setName(user.getName());
        updatedUser = userRepository.save(updatedUser);
        UserDetails userDetails = this.loadUserByUsername(updatedUser.getLogin());
        SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(
                userDetails, user.getPassword(), userDetails.getAuthorities()));
        return updatedUser;
    }

    @Override
    @Transactional
    public User updateRoles(User user) {
        roleRepository.deleteRolesByUserId(user.getId());
        User find = userRepository.findOne(user.getId());
        find.setRoles(user.getRoles());
        return userRepository.save(find);

    }

    @Override
    public void delete(Long id) {
        userRepository.delete(id);
    }
}
