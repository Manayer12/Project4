package com.example.project4.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty
    @Column(columnDefinition = "varchar(25) not null")
    private String name;

    @NotEmpty
    @Column(columnDefinition = "varchar(100) not null")
    private String description;

    @NotNull
    @Column(columnDefinition = "int not null")
    private Integer ticketprice;

    @NotNull
    @Column(columnDefinition = "int not null")
    private Integer chairsamount;


    @NotNull
    @Column(columnDefinition = "double not null")
    private Double hours;


    @NotEmpty
    @Column(columnDefinition = "varchar(10) not null check(rating='R18' or rating='R15' or rating='PG' or rating='G' or rating='PG12' or rating='PG15')")
//proper for specific AGE
    private String rating;



}
