package io.github.gpego1.primegarage.domain.dto.request;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;

public record RegisterRequest(@Email String username,
                              @NotBlank(message = "password is required") String password,
                              @NotBlank(message = "Name is required") String name,
                              @NotBlank(message = "Phone number is required") String phone,
                              @NotBlank(message = "Birth date is required") LocalDateTime birthDate) {
}
