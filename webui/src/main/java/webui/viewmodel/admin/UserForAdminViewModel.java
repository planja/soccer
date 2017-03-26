package webui.viewmodel.admin;

import domain.entity.role.Role;
import domain.entity.role.RoleType;
import domain.entity.user.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created by Никита on 26.03.2017.
 */
public class UserForAdminViewModel {

    private Long id;

    private String login;

    private List<Integer> roles = new ArrayList<>();

    public UserForAdminViewModel() {
    }

    public UserForAdminViewModel(User user) {
        this.id = user.getId();
        this.login = user.getLogin();
        this.roles = user.getRoles().stream().map(o -> Arrays.stream(RoleType.values())
                .filter(t -> Objects.equals(t.getText(), o.getRoleName())).findFirst().get().getValue()).collect(Collectors.toList());
    }

    public User toUser() {
        User user = new User();
        user.setId(this.getId());
        user.setRoles(roles.stream()
                .map(o -> new Role(user, Arrays.stream(RoleType.values()).filter(v -> v.getValue() == o).findFirst().get().getText())).collect(Collectors.toSet()));
        user.setLogin(login);
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

    public List<Integer> getRoles() {
        return roles;
    }

    public void setRoles(List<Integer> roles) {
        this.roles = roles;
    }
}
