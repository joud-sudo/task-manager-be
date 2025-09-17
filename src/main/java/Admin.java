import com.model.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Admin {
    String name;
    String password;
    Role role;
}
