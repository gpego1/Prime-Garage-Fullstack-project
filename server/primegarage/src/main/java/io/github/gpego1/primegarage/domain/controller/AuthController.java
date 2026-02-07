package io.github.gpego1.primegarage.domain.controller;
import io.github.gpego1.primegarage.domain.dto.request.LoginRequest;
import io.github.gpego1.primegarage.domain.dto.request.RegisterRequest;
import io.github.gpego1.primegarage.domain.dto.response.LoginResponse;
import io.github.gpego1.primegarage.domain.dto.response.RegisterResponse;
import io.github.gpego1.primegarage.domain.entity.User;
import io.github.gpego1.primegarage.domain.service.JwtService;
import io.github.gpego1.primegarage.domain.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.net.URI;
import java.util.List;



@RestController
@RequestMapping("/auth")
public class AuthController implements GenericController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AuthController(UserService userService, AuthenticationManager authenticationManager, JwtService jwtService) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(@RequestBody @Valid RegisterRequest registerRequest) {
        User registeredUser = userService.createUser(registerRequest);
        URI headerURI = generateHeaderLocation(registeredUser.getId());
        return ResponseEntity
                 .created(headerURI)
                .body(new RegisterResponse(registeredUser.getUsername(), registeredUser.getPassword()));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid LoginRequest loginRequest) {
        try {
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(loginRequest.username(), loginRequest.password());
            Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

            User user = (User) authentication.getPrincipal();
            String token = jwtService.generateToken(user);

            return ResponseEntity.ok(List.of(new LoginResponse(token), "User successfully logged in"));
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(List.of("message", "Invalid username or password"));
        }
    }
}
