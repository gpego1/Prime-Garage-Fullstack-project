package io.github.gpego1.primegarage.domain.dto.response;
import io.github.gpego1.primegarage.domain.dto.ErrorField;
import org.springframework.http.HttpStatus;

import java.util.List;

public record ErrorResponse(Integer status, String message, List<ErrorField> errors) {

    public static ErrorResponse defaultErrorResponse(String message) {
        return new ErrorResponse(HttpStatus.BAD_REQUEST.value(), message, List.of());
    }
    public static ErrorResponse conflictResponse(String message) {
        return new ErrorResponse(HttpStatus.CONFLICT.value(), message, List.of());
    }
}
