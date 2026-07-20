package com.code.rohan.module2.mvc.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.processing.Generated;
import java.time.LocalDate;

@Entity
@Getter // provided by lombok lib no need of manual code
@Setter
@Table(name = "employees") // by default table name is entity name but if we want diff then use it
public class EmployeeEntity {

    @Id // let hibernate know it as id field
    @GeneratedValue(strategy = GenerationType.AUTO) // to get autoincrement for id
    private Long id;


    private String name;
    private String email;
    private Integer age;
    private LocalDate dateOfJoining;

    @JsonProperty("isActive")
    private Boolean isActive;
}
