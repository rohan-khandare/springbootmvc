package com.code.rohan.module2.mvc.controllers;

import com.code.rohan.module2.mvc.dto.EmployeeDTO;
import com.code.rohan.module2.mvc.entities.EmployeeEntity;
import com.code.rohan.module2.mvc.repositories.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/employees") //base path
public class EmployeeController {

//    @GetMapping(path = "/getSecretMessage")
//    public  String getMySuperSecretMessage(){
//        return "Secret msg: hfb90wtq85";
//    }

    // injecting Employee Repository
    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @GetMapping(path = "/{employeeId}")
    public EmployeeEntity getEmployeeById(@PathVariable(name = "employeeId") Long id){

        return employeeRepository.findById(id).orElse(null);
        // if we don't wanna use Path variable name as same everywhere we name it to simple one
        // by @PathVariable(name = "employeeId") Long id ,now id is employeeId
    }

    @GetMapping
    public List<EmployeeEntity> getEmployees(@RequestParam(required = false) Integer age,
                                             @RequestParam(required = false) String sortBy){

        //we can use multiple @RequestParam it will inject automatically to function from path is available
        // @RequestParam is not optional by default to make it optional make required as false
        // in this case age is mandatory and sortBy is optional

            return employeeRepository.findAll();
    }

    @PostMapping
    public EmployeeEntity createNewEmployee(@RequestBody EmployeeEntity inputEmployee){
//        @RequestBody will map JSON data in body of req to employee obj as per the available and rest as null automatically

        return employeeRepository.save(inputEmployee);
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
