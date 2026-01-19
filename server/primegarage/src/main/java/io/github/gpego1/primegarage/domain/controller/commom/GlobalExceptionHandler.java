package io.github.gpego1.primegarage.domain.controller.commom;
import io.github.gpego1.primegarage.domain.dto.ErrorField;
import io.github.gpego1.primegarage.domain.dto.response.ErrorResponse;
import io.github.gpego1.primegarage.infra.exception.DuplicatedEntryException;
import io.github.gpego1.primegarage.infra.exception.InvalidFieldException;
import io.github.gpego1.primegarage.infra.exception.OperationNotAllowedException;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ServerErrorException;

import java.nio.file.AccessDeniedException;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_CONTENT)
    public ErrorResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        List<ErrorField> listErrors = fieldErrors
                .stream()
                .map(fe ->
                        new ErrorField(fe.getField(), fe.getDefaultMessage())
                )
                .collect(Collectors.toList());
        return new ErrorResponse(HttpStatus.UNPROCESSABLE_CONTENT.value(),
                "Validation error",
                    listErrors
                );
    }
    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse handleDuplicatedEntryException(DuplicatedEntryException ex) {
        return ErrorResponse.conflictResponse(ex.getMessage());
    }
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleOperationNotAllowedException(OperationNotAllowedException ex) {
        return ErrorResponse.conflictResponse(ex.getMessage());
    }
    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleServerErrorException(ServerErrorException ex) {
        return new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage(), List.of());
    }
    @ExceptionHandler
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ErrorResponse handleInvalidFieldException(InvalidFieldException ex) {
        return new ErrorResponse(
                HttpStatus.UNPROCESSABLE_ENTITY.value(),
                "Validation error: " + ex.getMessage(),
                List.of(new ErrorField(ex.getField(), ex.getMessage()))
        );
    }
    @ExceptionHandler
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ErrorResponse handleAccessDeniedException(AccessDeniedException ex) {
        return new ErrorResponse(HttpStatus.FORBIDDEN.value(), ex.getMessage(), List.of());
    }

}
