package com.code.rohan.module2.mvc.services;

import com.code.rohan.module2.mvc.dto.EmployeeDTO;
import com.code.rohan.module2.mvc.entities.EmployeeEntity;
import com.code.rohan.module2.mvc.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.theme.CookieThemeResolver;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {


    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper){
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }


    public EmployeeDTO getEmployeeById(Long id) {
            EmployeeEntity res =  employeeRepository.findById(id).orElse(null);
            return modelMapper.map(res,EmployeeDTO.class);
    }

    public List<EmployeeDTO> findAllEmployees() {
        List<EmployeeEntity> res =  employeeRepository.findAll();
        return res
                .stream()
                .map(employeeEntity -> modelMapper.map(employeeEntity,EmployeeDTO.class))
                .toList();
    }

    public EmployeeDTO CreateEmployee(EmployeeDTO inputEmployee) {
        EmployeeEntity input = modelMapper.map(inputEmployee,EmployeeEntity.class);
        EmployeeEntity res = employeeRepository.save(input);

        return modelMapper.map(res,EmployeeDTO.class);
    }

    public EmployeeDTO updateEmployee(EmployeeDTO inputEmployee, Long id) {

        EmployeeEntity input = modelMapper.map(inputEmployee,EmployeeEntity.class);
        input.setId(id);
        EmployeeEntity res = employeeRepository.save(input);

        return modelMapper.map(res,EmployeeDTO.class);

    }
}
