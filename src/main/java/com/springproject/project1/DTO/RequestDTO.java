package com.springproject.project1.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;

@Data
public class RequestDTO {
    @NotBlank(message = "Email is must")
    @Email(message = "Email should be valid")
    private String mail;
    @NotBlank(message = "Name is required")
    private String ename;
    @NotBlank(message = "DOB is required")
    private LocalDate dob;
    @NotBlank(message = "Salary should be in digit")
    private Double salary;
}
