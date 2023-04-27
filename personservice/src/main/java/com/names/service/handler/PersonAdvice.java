package com.names.service.handler;

import com.names.service.exception.ServerErrorException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.logging.Logger;

@RestControllerAdvice
public class PersonAdvice {

    private Logger logger = Logger.getLogger(PersonAdvice.class.getName());

    @ExceptionHandler(ServerErrorException.class)
    public ResponseEntity<String> serverError(ServerErrorException ex) {

        this.logger.info(ex.toString());
        return ResponseEntity.ok("Server error");
    }
}
