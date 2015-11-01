package com.rwr.exception;

/**
 * Created by Dmitriy on 01.11.2015.
 */
public class RwrDaoException extends RwrException {
    public RwrDaoException() {
    }

    public RwrDaoException(String message) {
        super(message);
    }

    public RwrDaoException(Throwable cause) {
        super(cause);
    }

    public RwrDaoException(String message, Throwable cause) {
        super(message, cause);
    }

    public RwrDaoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
