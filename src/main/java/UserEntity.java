import com.model.Role;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Entity
@Data
@Table(name = "TODO_USERS")
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(unique = true, nullable = false)
    private String username;

    public void setRole(Role role) {
        this.role = role;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;



}
