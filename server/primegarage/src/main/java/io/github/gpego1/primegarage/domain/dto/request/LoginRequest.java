package io.github.gpego1.primegarage.domain.dto.request;
import jakarta.validation.constraints.Email;

public record LoginRequest(@Email String username, String password) {
}
