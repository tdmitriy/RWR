package com.rwr.exception;

/**
 * Created by haswell on 11/3/15.
 */
public class RwrResourceNotFoundException extends RwrException {
    public RwrResourceNotFoundException() {
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
