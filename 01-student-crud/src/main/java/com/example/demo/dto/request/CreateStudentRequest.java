package com.example.demo.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateStudentRequest {
    private String name;
    private String email;
}
