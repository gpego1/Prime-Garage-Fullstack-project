package io.github.gpego1.primegarage.domain.dto;

import java.math.BigDecimal;

public record CarDTO(
        String model,
        String make,
        BigDecimal price,
        String fuel_type
) {
}
