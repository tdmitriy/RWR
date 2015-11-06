package com.rwr.controller;


import com.rwr.exception.RwrBadRequestException;
import com.rwr.exception.RwrJsonResponseException;
import com.rwr.exception.RwrResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;

@ControllerAdvice
public class RwrExceptionController {
    private static final Logger log = LoggerFactory.getLogger(RwrExceptionController.class);

    @ExceptionHandler(Exception.class)
    @ResponseBody
    protected ResponseEntity<RwrJsonResponseException> exceptionHandler(HttpServletRequest req, Exception exception) {
        log.error("Request: " + req.getRequestURL() + "\nraised " + exception);
        log.error("exception message=" + exception.getMessage());

        RwrJsonResponseException error = new RwrJsonResponseException();
        String errMsg = "An error has occurred on server.";
        error.setErrors(Collections.singletonList(errMsg));
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(RwrBadRequestException.class)
    @ResponseBody
    protected ResponseEntity<RwrJsonResponseException> badRequestHandler(
            HttpServletRequest req, RwrBadRequestException exception) {
        log.error("Request: " + req.getRequestURL() + "\nraised " + exception);
        log.error("exception message=" + exception.getMessage());
        RwrJsonResponseException error = new RwrJsonResponseException();
        error.setErrors(Collections.singletonList(exception.getMessage()));

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RwrResourceNotFoundException.class)
    @ResponseBody
    protected ResponseEntity<RwrJsonResponseException> resourceNotFoundHandler(
            HttpServletRequest req, RwrResourceNotFoundException exception) {
        log.error("Request: " + req.getRequestURL() + "\nraised " + exception);
        log.error("exception message=" + exception.getMessage());
        RwrJsonResponseException error = new RwrJsonResponseException();
        error.setErrors(Collections.singletonList(exception.getMessage()));

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
