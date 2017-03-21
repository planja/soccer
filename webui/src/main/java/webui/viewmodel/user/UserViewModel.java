package webui.viewmodel.user;

import domain.entity.role.Role;
import domain.entity.user.User;
import org.apache.commons.codec.binary.Base64;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by ShchykalauM on 07.03.2017.
 */
public class UserViewModel {

    private Long id;

    private String login;

    private String name;

    private String mail;

    private String password;

    private String imageString;

    public UserViewModel() {
    }

    public UserViewModel(User user) {
        this.id = user.getId();
        this.login = user.getLogin();
        this.name = user.getName();
        this.mail = user.getMail();
        this.password = user.getPassword();
        this.imageString = user.getImage() == null ? null : new Base64().encodeAsString(user.getImage());
    }


    public User toUser() {
        User user = new User();
        user.setId(id);
        user.setLogin(login);
        user.setName(name);
        user.setMail(mail);
        user.setPassword(password);
        if (user.getRoles().size() == 0)
            user.setRoles(Stream.of(new Role(user, "USER")).collect(Collectors.toSet()));
        user.setImage(imageString == null ? null : new Base64().decode(imageString));
        return user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImageString() {
        return imageString;
    }

    public void setImageString(String imageString) {
        this.imageString = imageString;
    }
}
