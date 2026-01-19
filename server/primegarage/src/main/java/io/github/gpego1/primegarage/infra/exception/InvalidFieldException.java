package io.github.gpego1.primegarage.infra.exception;

import lombok.Getter;

public class InvalidFieldException extends RuntimeException {

        @Getter
        private String field;

    public InvalidFieldException(String field, String message) {
        super(message);
        this.field = field;
    }
}
