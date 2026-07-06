package com.code.rohan.module2.mvc.repositories;

import com.code.rohan.module2.mvc.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {
    // by inheritance all crud operation methods are available we don't have to define

    // we can define custom methods here

}
