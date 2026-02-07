package io.github.gpego1.primegarage.domain.dto.request;
import io.github.gpego1.primegarage.domain.entity.Roles;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

public record RegisterRequest(@Email String username,
                              @NotBlank(message = "password is required") String password,
                              @NotBlank(message = "Name is required") String name,
                              Roles role,
                              @NotBlank(message = "Phone number is required") @Size(max = 14, message = "phone must have at most 14 characters") String phone,
                              @NotNull(message = "Birth date is required") LocalDateTime birthDate) {
}
