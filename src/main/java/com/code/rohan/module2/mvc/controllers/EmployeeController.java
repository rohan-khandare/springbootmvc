package com.code.rohan.module2.mvc.controllers;

import com.code.rohan.module2.mvc.dto.EmployeeDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class EmployeeController {

//    @GetMapping(path = "/getSecretMessage")
//    public  String getMySuperSecretMessage(){
//        return "Secret msg: hfb90wtq85";
//    }

    @GetMapping(path = "/employee/{employeeId}")
    public EmployeeDTO getEmployeeById(@PathVariable Long employeeId){
        return new EmployeeDTO(employeeId,"rohan","rohanb2@gmail.com",21, LocalDate.of(2026,7,3),true);
    }

    @GetMapping(path = "/employee")
    public String getEmployee(@RequestParam Integer age){
            return "age is : " + age;
    }

}
