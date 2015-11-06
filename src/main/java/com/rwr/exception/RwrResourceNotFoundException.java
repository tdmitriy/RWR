package com.rwr.exception;

public class RwrResourceNotFoundException extends RwrException {
    public RwrResourceNotFoundException() {
        super();
    }

    public RwrResourceNotFoundException(String message) {
        super(message);
    }

    public RwrResourceNotFoundException(Throwable cause) {
        super(cause);
    }

    public RwrResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
