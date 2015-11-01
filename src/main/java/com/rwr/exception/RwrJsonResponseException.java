package com.rwr.exception;

import java.util.List;

/**
 * Created by Dmitriy on 01.11.2015.
 */
public class RwrJsonResponseException {
    private List<String> errors;

    public RwrJsonResponseException() {
    }

    public RwrJsonResponseException(List<String> errors) {
        this.errors = errors;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
