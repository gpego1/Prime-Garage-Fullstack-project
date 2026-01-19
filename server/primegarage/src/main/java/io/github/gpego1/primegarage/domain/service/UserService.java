package io.github.gpego1.primegarage.domain.service;
import io.github.gpego1.primegarage.domain.entity.User;
import io.github.gpego1.primegarage.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }
}
