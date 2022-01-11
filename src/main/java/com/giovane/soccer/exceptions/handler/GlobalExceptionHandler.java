package com.giovane.soccer.exceptions.handler;

import com.giovane.soccer.exceptions.details.ExceptionDetailsInternalError;
import com.giovane.soccer.exceptions.details.ExceptionDetailsNotFound;
import com.giovane.soccer.exceptions.details.ExceptionMethodNotValidDetails;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.validation.FieldError;
import static org.springframework.http.HttpStatus.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;
import reactor.core.publisher.Mono;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(NOT_FOUND)
    public Mono<ExceptionDetailsNotFound> handlerNotFoundException(NotFoundException e){
        return Mono.just(ExceptionDetailsNotFound.builder()
                .status(NOT_FOUND.value())
                .title("Not found")
                .timestamp(Instant.now())
                .details(e.getMessage())
                .developerMessage("Include a valid ID. Make sure it exists")
                .build());
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(BAD_REQUEST)
    public Mono<ExceptionMethodNotValidDetails> handlerMethodNotValid(MethodArgumentNotValidException e){
        Map<String, String> error = new HashMap<>();
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        fieldErrors.forEach(p -> error.put(p.getField(), p.getDefaultMessage()));

        return Mono.just(ExceptionMethodNotValidDetails.builder()
                .status(BAD_REQUEST.value())
                .title("Body contains invalid JSON")
                .timestamp(Instant.now())
                .details(error)
                .developerMessage("Error! Check the body constraints")
                .build());
    }

    @ExceptionHandler(InternalServerError.class)
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    public Mono<ExceptionDetailsInternalError> handlerInternalServerError(){
       return Mono.just(ExceptionDetailsInternalError.builder()
                .status(INTERNAL_SERVER_ERROR.value())
                .title("Internal Server Error")
                .timestamp(Instant.now())
                .details("Something went wrong")
                .developerMessage("Check the request")
                .build());
    }

}
