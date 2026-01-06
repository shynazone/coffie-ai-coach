package com.coffie.coffie_ai_coach.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler{

    //validation errors
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleValidationException(MethodArgumentNotValidException ex){

        String message = ex.getBindingResult().getFieldErrors().get(0).getDefaultMessage();

        return handleAPIError(HttpStatus.BAD_REQUEST, message);

    }

    //catch all
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleGenericException(Exception ex){

        System.out.println(ex.getMessage());

        return handleAPIError(HttpStatus.INTERNAL_SERVER_ERROR,"Something went wrong");

    }

    @ExceptionHandler(JournalNotFoundException.class)
    public ResponseEntity<ApiError> handleJournalNotFoundException(JournalNotFoundException ex){

        return handleAPIError(HttpStatus.NOT_FOUND, ex.getMessage());
    }

    private ResponseEntity<ApiError>  handleAPIError(HttpStatus status, String message){

        ApiError error = new ApiError(status.value(),
                message,
                System.currentTimeMillis());

        return new ResponseEntity<>(error,status);
    }



}
