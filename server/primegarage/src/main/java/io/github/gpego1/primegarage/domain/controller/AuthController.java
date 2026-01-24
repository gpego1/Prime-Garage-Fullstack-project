package io.github.gpego1.primegarage.domain.controller;
import io.github.gpego1.primegarage.domain.dto.request.RegisterRequest;
import io.github.gpego1.primegarage.domain.dto.response.RegisterResponse;
import io.github.gpego1.primegarage.domain.entity.User;
import io.github.gpego1.primegarage.domain.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/auth")
public class AuthController implements GenericController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(@RequestBody @Valid RegisterRequest registerRequest) {
        User registeredUser = userService.createUser(registerRequest);
        URI headerURI = generateHeaderLocation(registeredUser.getId());
        return ResponseEntity
                 .created(headerURI)
                .body(new RegisterResponse(registeredUser.getUsername(), registeredUser.getPassword()));
    }
}
