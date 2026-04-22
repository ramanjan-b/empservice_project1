package com.springproject.project1.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "employees6")
public class MyEntiity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq", sequenceName = "user_seq", allocationSize = 50)
    @Column(name="EMPLOYEE ID")
    private Long id;


    @NotNull
    @Column(nullable = false,name="FIRST NAME")
    private String ename;

    @Email
    @NotNull
    @Column(nullable = false, unique = true,name="OFFICIAL MAIL")
    private String mail;
@NotNull
@Column(name="BIRTH DATE")
private LocalDate dob;
//@NotNull
@Column(name="JOINING DATE")
private LocalDate doj;
    @Column(nullable = false,name="MONTHLY SALARY")
    private Double salary;
    @NotNull
    @Column(name="CREATION DATE")
//    @JsonFormat(pattern="dd:MM:YYYY")
    private LocalDate creationDate;
//    @JsonFormat(pattern="dd:MM:YYYY HH:mm:ss")
    @NotNull
    @Column(name="CREATION TIME")
    private LocalTime creationTime;
    @NotNull
    @Column(name="UPDATE HISTORY")
    private String updatedAt;
@NotNull
@Column(name="JOB ROLE")
private String role;
}
