package io.github.gpego1.primegarage.service;
import io.github.gpego1.primegarage.domain.dto.request.RegisterRequest;
import io.github.gpego1.primegarage.domain.dto.response.RegisterResponse;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    public RegisterResponse register(RegisterRequest registerRequest) {
        return new RegisterResponse(
                registerRequest.username(),
                registerRequest.password()
        );
    }
}
