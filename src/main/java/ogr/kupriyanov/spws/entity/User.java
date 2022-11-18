package ogr.kupriyanov.spws.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "login_user")
    private String loginUser;
    @Column(name = "name_user")
    private String nameUser;
    @Column(name = "password_user")
    private String passwordUser;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_roles"
            ,joinColumns = @JoinColumn(name = "login_user")
            ,inverseJoinColumns = @JoinColumn(name = "id_role")
    )
    private List<Role> roles;

    public User() {
    }

    public User(String loginUser, String nameUser, String passwordUser) {
        this.loginUser = loginUser;
        this.nameUser = nameUser;
        this.passwordUser = passwordUser;
    }

    public void addRole(Role role){
        if (roles == null){
            roles = new ArrayList<>();
        }
        roles.add(role);
    }

    public String getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(String loginUser) {
        this.loginUser = loginUser;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getPasswordUser() {
        return passwordUser;
    }

    public void setPasswordUser(String passwordUser) {
        this.passwordUser = passwordUser;
    }

    @Override
    public String toString() {
        return "User{" +
                "loginUser='" + loginUser + '\'' +
                ", nameUser='" + nameUser + '\'' +
                ", passwordUser='" + passwordUser +
                '}';
    }
}
