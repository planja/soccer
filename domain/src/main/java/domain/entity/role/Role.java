package domain.entity.role;

import domain.entity.user.User;

import javax.persistence.*;

/**
 * Created by admin on 01.11.2016.
 */

@Entity
@Table(name = "user_roles")
public class Role {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "role_name")
    private String roleName;

    public Role() {
    }

    public Role(User user, String roleName) {
        this.user = user;
        this.roleName = roleName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
