package com.example.customannotation;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

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
    public List<ErrorInfo> handler(MethodArgumentNotValidException exception){
        return exception.getBindingResult().getAllErrors()
                .stream().map(this::getErrorInfo)
                .collect(Collectors.toList());
    }

    public ErrorInfo getErrorInfo(ObjectError error){
        var field = (error instanceof FieldError) ? ((FieldError) error).getField() : error.getObjectName();
        var message = error.getDefaultMessage();
        return new ErrorInfo(field, message);
    }

    @Data
    @AllArgsConstructor
    static class ErrorInfo{
        private String field;
        private String message;
    }
}
