package io.github.gpego1.primegarage.service;
import io.github.gpego1.primegarage.domain.controller.AuthController;
import io.github.gpego1.primegarage.domain.dto.request.RegisterRequest;
import io.github.gpego1.primegarage.domain.dto.response.RegisterResponse;
import io.github.gpego1.primegarage.domain.entity.User;
import io.github.gpego1.primegarage.domain.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @InjectMocks
    private AuthController authController;

    @Mock
    private UserService userService;

    @Mock
    private AuthServiceTest authService;

    @Test
    public void registerUser()
    {
        RegisterRequest request = new RegisterRequest("user@email.com", "user123", "User1", "199282918", LocalDateTime.now());


        User testUser = new User();
        testUser.setId(10L);
        testUser.setUsername(request.username());
        testUser.setPassword(request.password());

        when(userService.createUser(any(RegisterRequest.class)))
                .thenReturn(testUser);

        ResponseEntity<RegisterResponse> response =
                authController.register(request);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());

        assertNotNull(response.getHeaders().getLocation(),
                "Header Location não deveria ser nulo");

        assertNotNull(response.getBody());
        assertEquals(testUser.getUsername(), response.getBody().username());
        assertEquals(testUser.getPassword(), response.getBody().password());


    }
}
