package io.github.gpego1.primegarage.domain.entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public enum Roles {
    @Enumerated(EnumType.STRING)
    CLIENT,
    MANAGER,
    ADMIN
}
