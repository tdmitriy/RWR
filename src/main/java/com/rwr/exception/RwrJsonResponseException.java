package com.rwr.exception;

import java.util.List;

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
