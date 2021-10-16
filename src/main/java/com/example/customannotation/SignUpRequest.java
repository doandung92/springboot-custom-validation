package com.example.customannotation;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class SignUpRequest {
    @NotBlank
    private String username;

    @EvenNumber
    private Integer age;
}
