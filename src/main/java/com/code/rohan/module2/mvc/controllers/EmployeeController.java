package com.code.rohan.module2.mvc.controllers;

import com.code.rohan.module2.mvc.dto.EmployeeDTO;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping(path = "/employees") //base path
public class EmployeeController {

//    @GetMapping(path = "/getSecretMessage")
//    public  String getMySuperSecretMessage(){
//        return "Secret msg: hfb90wtq85";
//    }

    @GetMapping(path = "/{employeeId}")
    public EmployeeDTO getEmployeeById(@PathVariable(name = "employeeId") Long id){

        return new EmployeeDTO(id,"rohan","rohanb2@gmail.com",21, LocalDate.of(2026,7,3),true);

        // if we don't wanna use Path variable name as same everywhere we name it to simple one
        // by @PathVariable(name = "employeeId") Long id ,now id is employeeId
    }

    @GetMapping
    public String getEmployee(@RequestParam Integer age,
                              @RequestParam(required = false) String sortBy){

        //we can use multiple @RequestParam it will inject automatically to function from path is available
        // @RequestParam is not optional by default to make it optional make required as false
        // in this case age is mandatory and sortBy is optional

            return "age is : " + age + sortBy;
    }

    @PostMapping
    public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO inputEmployee){
//        @RequestBody will map json data in body of req to employee obj as per the available and rest as null automatically
        inputEmployee.setId(31L);
        return inputEmployee;
    }

    @PutMapping
    public String updateEmployee(){
        return "hello from put ";
    }

    @PatchMapping
    public String updateSomePartOfEmployee(){
        return "hello from patch";
    }

    @DeleteMapping
    public String DeleteEmployee(){
        return "Employee Deleted";
    }

}
