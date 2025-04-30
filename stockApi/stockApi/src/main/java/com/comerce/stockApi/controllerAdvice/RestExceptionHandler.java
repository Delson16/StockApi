package com.comerce.stockApi.controllerAdvice;

import com.comerce.stockApi.exceptions.InvalidDataException;
import com.comerce.stockApi.exceptions.NoProductsRegisteredException;
import com.comerce.stockApi.exceptions.ProductNotFoundException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    private ResponseEntity<RestErrorMessage> ProductNotFoundHandler(ProductNotFoundException exception) {
        RestErrorMessage bodyResponse = new RestErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(bodyResponse);
    }

    @ExceptionHandler(NoProductsRegisteredException.class)
    private ResponseEntity<RestErrorMessage> NoProductsRegisteredHandler(NoProductsRegisteredException exception) {
        RestErrorMessage bodyResponse = new RestErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(bodyResponse);
    }
    
    @ExceptionHandler(InvalidDataException.class)
    private ResponseEntity<RestErrorMessage> InvalidDataHandler(InvalidDataException exception) {
        RestErrorMessage bodyResponse = new RestErrorMessage(HttpStatus.BAD_REQUEST, exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bodyResponse);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    private ResponseEntity<RestErrorMessage> handleHttpMessageNotReadable() {
        RestErrorMessage bodyResponse = new RestErrorMessage(HttpStatus.BAD_REQUEST, "Dados inválidos");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bodyResponse);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    private ResponseEntity<RestErrorMessage> handleMethodArgumentNotValid() {
        RestErrorMessage bodyResponse = new RestErrorMessage(HttpStatus.BAD_REQUEST, "Dados inválidos");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bodyResponse);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    private ResponseEntity<RestErrorMessage> MethodArgumentTypeMismatchHandle() {
        RestErrorMessage bodyResponse = new RestErrorMessage(HttpStatus.BAD_REQUEST, "Dados inválidos");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bodyResponse);
    }
        
    @ExceptionHandler(ConstraintViolationException.class)
    private ResponseEntity<RestErrorMessage> ConstraintViolationHandler() {
        RestErrorMessage bodyResponse = new RestErrorMessage(HttpStatus.BAD_REQUEST, "Dados inválidos");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bodyResponse);
    }
    
    @ExceptionHandler(NoHandlerFoundException.class)
    private ResponseEntity<RestErrorMessage> handleNoHandlerFoundHandler(NoHandlerFoundException exception) {
        RestErrorMessage bodyResponse = new RestErrorMessage(HttpStatus.NOT_FOUND, "Rescurso não encontrado");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(bodyResponse);
    }
    
    @ExceptionHandler(Exception.class)
    private ResponseEntity<RestErrorMessage> exceptionHandler(Exception exception) {
        RestErrorMessage bodyResponse = new RestErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR, "Erro desconhecido" + exception.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(bodyResponse);
    }

}
