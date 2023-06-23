package com.curso.resources.exceptions;

import com.curso.services.exceptions.DatabaseException;
import com.curso.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException err, HttpServletRequest req){
        String errMsg = "Recurso não encontrado";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError e = new StandardError(Instant.now(), status.value(), errMsg, err.getMessage(), req.getRequestURI());
        return ResponseEntity.status(status).body(e);
    }
    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<StandardError> dataBase(DatabaseException err, HttpServletRequest req){
        String errMsg = "Erro no banco de dados";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError e = new StandardError(Instant.now(), status.value(), errMsg, err.getMessage(), req.getRequestURI());
        return ResponseEntity.status(status).body(e);
    }
}
