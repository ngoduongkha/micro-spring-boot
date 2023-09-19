package io.micro_spring_boot.building_blocks.shared_kernel.filter;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.reactive.result.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalControllerAdvice extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseStatus(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleException(Exception e) {
        return e.getMessage();
    }
}
