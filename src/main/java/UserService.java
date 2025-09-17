import com.model.Role;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public UserEntity registerUser(String username, String password, Role role) {
        if (userRepo.findByUsername(username) != null) {
            throw new RuntimeException("Username is already in use");
        }

        UserEntity user = new UserEntity();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setRole(role != null ? role : Role.USER);

        return userRepo.save(user);
    }

    public UserEntity authenticate(String username, String rawPassword) {
        Optional<UserEntity> userOptional = Optional.ofNullable(userRepo.findByUsername(username));
        return userOptional
                .filter(user -> passwordEncoder.matches(rawPassword, user.getPassword()))
                .orElse(null);
    }
}
