package com.example.customannotation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@SpringBootApplication
@RestController
public class CustomAnnotationApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomAnnotationApplication.class, args);
    }

    @PostMapping("/")
    public String index(@Valid @RequestBody SignUpRequest request){
        return "Hello " + request.getUsername();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public String handler(MethodArgumentNotValidException exception){
        var errors = exception.getBindingResult().getFieldErrors();
        var field = errors.get(0).getField();
        var message = errors.get(0).getDefaultMessage();
        return field + " : " + message;
    }
}
