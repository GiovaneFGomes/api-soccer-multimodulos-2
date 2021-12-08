package com.giovane.soccer.exceptions.handler;

import com.giovane.soccer.exceptions.details.ExceptionDetailsInternalError;
import com.giovane.soccer.exceptions.details.ExceptionDetailsNotFound;
import com.giovane.soccer.exceptions.details.ExceptionMethodNotValidDetails;
import com.giovane.soccer.exceptions.notfound.NotFoundException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.http.HttpStatus.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(NOT_FOUND)
    public ExceptionDetailsNotFound handlerNotFoundException(NotFoundException e){
       return ExceptionDetailsNotFound.builder()
                .status(NOT_FOUND.value())
                .title("Not found")
                .timestamp(Instant.now())
                .details(e.getMessage())
                .developerMessage("Include a valid ID. Make sure it exists.")
                .build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(BAD_REQUEST)
    public ExceptionMethodNotValidDetails handlerMethodNotValid(MethodArgumentNotValidException e){
        Map<String, String> error = new HashMap<>();
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        fieldErrors.forEach(p -> error.put(p.getField(), p.getDefaultMessage()));

        return ExceptionMethodNotValidDetails.builder()
                .status(BAD_REQUEST.value())
                .title("Body contains invalid JSON")
                .timestamp(Instant.now())
                .details(error)
                .developerMessage("Error! Check the body constraints.")
                .build();
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    public ExceptionDetailsInternalError handlerInternalServerError(){
       return ExceptionDetailsInternalError.builder()
                .status(INTERNAL_SERVER_ERROR.value())
                .title("Internal Server Error")
                .timestamp(Instant.now())
                .details("You sent a request that this server didn't understand")
                .developerMessage("Check the request")
                .build();
    }

}
