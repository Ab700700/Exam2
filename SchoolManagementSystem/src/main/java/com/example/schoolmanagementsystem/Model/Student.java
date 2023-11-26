package com.example.schoolmanagementsystem.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
    @NotEmpty(message = "ID should not be empty")
    @Pattern(regexp = "[0-9]+",message = "ID should be only numbers")
    private String ID;
    @NotEmpty(message = "Name should not be empty")
    @Pattern(regexp = "[a-zA-Z\s]+",message = "Name should only contain letters and space")
    private String name;
    @NotNull(message = "Age should not be empty")
    @Positive(message = "Age must be positive number")
    private int age;
    @NotEmpty(message = "Major should not be empty")
    private String major;
}
