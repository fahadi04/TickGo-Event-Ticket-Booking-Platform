package com.fahad.TickGo.controllers;

import com.fahad.TickGo.domain.dtos.ErrorDTO;
import com.fahad.TickGo.exceptions.UserNotFoundException;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleUserNotFoundException(UserNotFoundException ex) {
        log.error("Caught UserNotFoundExceptions", ex);
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setError("User not found");
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDTO> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error("Caught MethodArgumentsNotValidExceptions", e);
        ErrorDTO errorDTO = new ErrorDTO();

        BindingResult bindingResult = e.getBindingResult();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();

        String validationFailed = fieldErrors
                .stream().findFirst().map(fieldError ->
                        fieldError.getField() + ": " + fieldError.getDefaultMessage()
                ).orElse("Validation Failed");

        errorDTO.setError(validationFailed);
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorDTO> handleConstraintViolationException(ConstraintViolationException ex) {
        log.error("Caught constraintValidationExceptions", ex);
        ErrorDTO errorDTO = new ErrorDTO();

        String constraintViolationError = ex.getConstraintViolations()
                .stream().findFirst().map(violation ->
                        violation.getPropertyPath() + ": " + violation.getMessage()
                ).orElse("Constraint violation error");

        errorDTO.setError(constraintViolationError);
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> handleException(Exception exception) {
        log.error("Caught exception", exception);
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setError("Unknown error occurred!!");
        return new ResponseEntity<>(errorDTO, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
