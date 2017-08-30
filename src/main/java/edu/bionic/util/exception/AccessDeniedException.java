package edu.bionic.util.exception;

/**
 * Created by denis on 29.08.17.
 */
public class AccessDeniedException extends RuntimeException {

    public AccessDeniedException(String message) {
        super(message);
    }
}
