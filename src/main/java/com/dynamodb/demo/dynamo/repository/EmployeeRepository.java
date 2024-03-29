package com.dynamodb.demo.dynamo.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.dynamodb.demo.dynamo.entity.Employee;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepository {

    private final DynamoDBMapper dynamoDBMapper;

    public EmployeeRepository(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }

    public Employee save(Employee employee){
        dynamoDBMapper.save(employee);
        return employee;
    }

    public Employee getEmployeeById(String employeeId){
        return dynamoDBMapper.load(Employee.class,employeeId);
    }

    public String delete(String employeeId){
        Employee emp =dynamoDBMapper.load(Employee.class,employeeId);
        dynamoDBMapper.delete(emp);
        return "Employee Deleted";
    }

    public String update(String employeId,Employee employee){
        dynamoDBMapper.save(employee,new DynamoDBSaveExpression()
                .withExpectedEntry("employeeId",
                        new ExpectedAttributeValue(
                                new AttributeValue().withS(employeId)
                        )));
        return employeId;
    }


}
