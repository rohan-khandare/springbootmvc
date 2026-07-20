package com.code.rohan.module2.mvc.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

//using lambok for getter setter and constructor for no name conflict anywhere.
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    // DTO= Data Transfer Obj - presentation to service not persistence
    // it is just POJO class plain old java obj
    
    private Long id;
    private String name;
    private String email;
    private Integer age;
    private LocalDate dateOfJoining;

    @JsonProperty("isActive")
    private Boolean isActive;
}
