package com.rwr.exception;

/**
 * Created by Dmitriy on 01.11.2015.
 */
public class RwrBadRequestException extends RwrException {
    public RwrBadRequestException() {
    }

    public RwrBadRequestException(String message) {
        super(message);
    }

    public RwrBadRequestException(Throwable cause) {
        super(cause);
    }
}
