package io.github.gpego1.primegarage.domain.service;
import io.github.gpego1.primegarage.domain.dto.request.RegisterRequest;
import io.github.gpego1.primegarage.domain.entity.User;
import io.github.gpego1.primegarage.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

//    public Optional<User> findById(Long id) {
//        return userRepository.findById(id);
//    }
    public User createUser(RegisterRequest dto) {
        User user = new User(
                dto.username(),
                this.passwordEncoder.encode(dto.password()),
                dto.name(),
                dto.role(),
                dto.phone(),
                dto.birthDate());

        return userRepository.save(user);
    }

}
