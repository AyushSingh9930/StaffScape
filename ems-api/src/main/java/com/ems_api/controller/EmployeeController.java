package com.ems_api.controller;

import com.ems_api.entity.Employee;
import com.ems_api.repository.EmployeeRepository;
import com.ems_api.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class EmployeeController
{
    @Autowired
    private EmployeeRepository repository;

    @Autowired
    private EmployeeService service;
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/employee")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee)
    {
        return new ResponseEntity<Employee>(service.addEmployee(employee), HttpStatus.CREATED);
    }
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    @GetMapping("/employee/search/{empId}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long empId) {
        Employee employee = service.getEmployeeById(empId);
        if(employee != null) {
            return ResponseEntity.ok(employee);             // 200 OK
        } else{
            return ResponseEntity.notFound().build();       // 404, no body
        }
    }
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees()
    {
        List<Employee> employeeList = service.getAllEmployees();
        if (employeeList!=null)
            return new ResponseEntity<>(employeeList, HttpStatus.OK);
        else
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NOT_FOUND);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/employee/{empId}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable Long empId)
    {
        service.deleteEmployeeById(empId);
        return new ResponseEntity<>("Employee deleted successfully",
                    HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/employee")
    public ResponseEntity<String> updateProduct(@RequestBody Employee employee)
    {
       if(repository.existsById(employee.getId()))
       {
           service.updateProduct(employee);
           return new ResponseEntity<>("Employee "+employee.getFirst_Name()+" updated successfully", HttpStatus.OK);
       }
       else
           return new ResponseEntity<>("Employee Not Found!", HttpStatus.NOT_FOUND);
    }
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
        @GetMapping("/employee/{keyword}")
    public ResponseEntity<List<Employee>> searchEmployeesByKeyword(@PathVariable String keyword)
    {
         return new ResponseEntity<>(service.searchEmployeesByKeyword(keyword), HttpStatus.OK);
    }
}
