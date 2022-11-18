package ogr.kupriyanov.spws.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_role")
    private long idRole;
    @Column(name = "name_role")
    private String nameRole;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_roles"
            ,joinColumns = @JoinColumn(name = "id_role")
            ,inverseJoinColumns = @JoinColumn(name = "login_user")
    )
    private List<User> users;

    public Role() {
    }

    public Role(String nameRole) {
        this.nameRole = nameRole;
    }

    public void addUser(User user){
        if (users == null){
            users = new ArrayList<>();
        }
        users.add(user);
    }

    public long getIdRole() {
        return idRole;
    }

    public void setIdRole(long idRole) {
        this.idRole = idRole;
    }

    public String getNameRole() {
        return nameRole;
    }

    public void setNameRole(String nameRole) {
        this.nameRole = nameRole;
    }

    @Override
    public String toString() {
        return "Role{" +
                "idRole=" + idRole +
                ", nameRole='" + nameRole +
                '}';
    }
}
