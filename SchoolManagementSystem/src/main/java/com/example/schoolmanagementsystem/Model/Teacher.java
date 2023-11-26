package com.example.schoolmanagementsystem.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Teacher {
    @NotEmpty(message = "ID should not be empty")
    @Pattern(regexp = "[0-9]+",message = "ID should be only numbers")
    private String ID;
    @NotEmpty(message = "Name should not be empty")
    @Pattern(regexp = "[a-zA-Z\s]+",message = "Name should only contain letters and space")
    private String name;
    @NotNull(message = "Salary should not be empty")
    @Positive(message = "Salary should be positive")
    @Min(value = 2500 , message = "salary should be at least 2500")
    private double salary;
}
