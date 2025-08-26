package edu.eci.ieti.integrador.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class NotFoundException extends ResponseStatusException {
    public NotFoundException(String id) {
        super(HttpStatus.NOT_FOUND, "product with ID: "+id+" not found");
    }
}
