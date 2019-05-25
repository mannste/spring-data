package com.mannste.springcrud.cruddemo.dao;

import com.mannste.springcrud.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
