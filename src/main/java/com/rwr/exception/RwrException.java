package com.rwr.exception;

public class RwrException extends RuntimeException {
    public RwrException() {
        super();
    }

    public RwrException(String message) {
        super(message);
    }

    public RwrException(String message, Throwable cause) {
        super(message, cause);
    }

    public RwrException(Throwable cause) {
        super(cause);
    }

    public RwrException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
