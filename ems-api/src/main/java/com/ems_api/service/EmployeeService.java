package com.ems_api.service;

import com.ems_api.entity.Employee;
import com.ems_api.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;

@Service
public class EmployeeService
{
    @Autowired
    private EmployeeRepository repository;

    public Employee addEmployee(Employee employee)
    {
        return repository.save(employee);
    }

    public Employee getEmployeeById(Long empId)
    {
        return repository.findById(empId)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "Employee " + empId + " not found")
                );
    }

    public List<Employee> getAllEmployees()
    {
        return repository.findAll();
    }

    public void deleteEmployeeById(Long empId)
    {
        repository.deleteById(empId);
    }

    public void updateProduct(Employee employee)
    {
        repository.save(employee);
    }

    public List<Employee> searchEmployeesByKeyword(String keyword)
    {
        return repository.getEmployeesByKeyword(keyword);
    }
}
