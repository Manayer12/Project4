package com.example.project4.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Viwer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    @Column(columnDefinition = "varchar(25) not null")
    private String name;

    @NotNull
    @Column(columnDefinition = "int not null ")
    private Integer age;

    @Email
    @Column(columnDefinition = "varchar(30) unique not null ")
    private String email;


    @Column(columnDefinition = "varchar(30) unique not null")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{7,}$")
    private String password;


    @NotNull
    @Column(columnDefinition = "int not null ")
    private Integer balance;

    @Column(columnDefinition = "int default 0  ")
    Integer amountoftickets ;






}
