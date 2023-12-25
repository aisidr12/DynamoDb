package com.dynamodb.demo.dynamo.controller;

import com.dynamodb.demo.dynamo.entity.Employee;
import com.dynamodb.demo.dynamo.repository.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {


    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @PostMapping("/employee")
    public Employee saveEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable("id") String employeeId){
        return employeeRepository.getEmployeeById(employeeId);
    }
    @DeleteMapping("/employee/{id}")
    public String deleteEmployee(@PathVariable("id") String employeeId){
        return employeeRepository.delete(employeeId);
    }

    @PutMapping("/employee/{id}")
    public  String updateEmployee(@PathVariable("id")String employeeId,@RequestBody Employee employee){
        return employeeRepository.update(employeeId,employee);
    }


}
