package com.mannste.springcrud.cruddemo.rest;

import com.mannste.springcrud.cruddemo.entity.Employee;
import com.mannste.springcrud.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    // inject employee dao
    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService){
        employeeService = theEmployeeService;
    }

    // expose "/employees" returning a list of employees
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    // expose "/employees/{employeeId}" returning a single employee
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        Employee employee = employeeService.findById(employeeId);

        if (employee == null){
            throw new RuntimeException("Employee Id not Found - " + employeeId);
        }

        return employee;
    }

    // expose "/employees" add a new employee through POST request
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        employee.setId(0);

        employeeService.save(employee);

        return employee;
    }

    // expose "/employees" to update an existing employee
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        employeeService.save(employee);

        return employee;
    }

    // expose "/employees/{employeeId}" to delete an existing employee
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        Employee employee = employeeService.findById(employeeId);

        // throw an exception if the employee does not exist
        if(employee == null){
            throw new RuntimeException("EmployeeId not found - " + employeeId);
        }

        employeeService.deleteById(employeeId);

        return "Deleted Employee Id - " + employeeId;
    }



}
