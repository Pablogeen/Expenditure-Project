package com.rey.expenditure.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorDetails> handleInvalidIncome(InvalidIncomeException e, WebRequest request){
        log.info("Handling error for invalid income");
        ErrorDetails errorDetails = new ErrorDetails(
                "INCOME MUST BE VALID",
                e.getMessage(),
                request.getDescription(false),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleGenericErrors(Exception e, WebRequest request){
        log.info("Handling Generic errors: {}",e.getMessage());
        ErrorDetails errorDetails = new ErrorDetails(
                "INTERNAL_SERVER_ERROR",
                "Oops, Something went wrong",
                request.getDescription(false),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);

    }
}
