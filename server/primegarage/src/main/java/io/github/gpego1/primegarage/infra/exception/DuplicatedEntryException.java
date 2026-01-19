package io.github.gpego1.primegarage.infra.exception;

public class DuplicatedEntryException extends RuntimeException {
    public DuplicatedEntryException(String message) {
        super(message);
    }
}
