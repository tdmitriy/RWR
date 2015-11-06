package com.rwr.exception;

public class RwrBadRequestException extends RwrException {
    public RwrBadRequestException() {
        super();
    }

    public RwrBadRequestException(String message) {
        super(message);
    }

    public RwrBadRequestException(Throwable cause) {
        super(cause);
    }
}
