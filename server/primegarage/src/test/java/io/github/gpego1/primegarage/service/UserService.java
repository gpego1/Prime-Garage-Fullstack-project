package io.github.gpego1.primegarage.service;
import io.github.gpego1.primegarage.domain.dto.request.RegisterRequest;
import io.github.gpego1.primegarage.domain.dto.response.RegisterResponse;
import io.github.gpego1.primegarage.domain.entity.User;
import io.github.gpego1.primegarage.domain.repository.UserRepository;
import jakarta.validation.Valid;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.mockito.Mockito.mock;

public class UserService {
    private UserRepository repository = mock(UserRepository.class);
    private User user = new User(1L, "user@email.com", "password123","useeer", "199928192", LocalDateTime.now(), null, null );


    @Test
    public void findById() {
        repository.findById(user.getId()).ifPresent(System.out::println);
        System.out.println(user.getName());
    }

    @Test
    public void register() {
        RegisterRequest request = new RegisterRequest("joao@email.com", "joao456","userJoao", "11827822", LocalDateTime.now());
        User registeredUser = new User(
                2L,
                request.username(),
                request.password(),
                request.name(),
                request.phone(),
                request.birthDate(),
                null,
                null
        );
        RegisterResponse registerResponse = new RegisterResponse(registeredUser.getUsername(), registeredUser.getPassword());
        System.out.println("Email: " + registerResponse.username() + " \nPassword: " + registerResponse.password());



    }
}
