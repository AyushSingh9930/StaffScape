package com.ems_api.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDate;
import lombok.Data;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String first_Name;
    private String last_Name;
    private String email;
    private String designation;
    private Double salary;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate date_of_join;

    private boolean active;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", first_Name='" + first_Name + '\'' +
                ", last_Name='" + last_Name + '\'' +
                ", email='" + email + '\'' +
                ", department='" + department + '\'' +
                ", designation='" + designation + '\'' +
                ", salary=" + salary +
                ", date_of_join=" + date_of_join +
                ", active=" + active +
                '}';
    }

    private String department;

    public Long getId() {
        return id;
    }

    public Employee(Long id, String last_Name, String first_Name, String email, String designation, String department, Double salary, boolean active, LocalDate date_of_join) {
        this.id = id;
        this.last_Name = last_Name;
        this.first_Name = first_Name;
        this.email = email;
        this.designation = designation;
        this.department = department;
        this.salary = salary;
        this.active = active;
        this.date_of_join = date_of_join;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirst_Name(String first_Name) {
        this.first_Name = first_Name;
    }

    public void setLast_Name(String last_Name) {
        this.last_Name = last_Name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setDate_of_join(LocalDate date_of_join) {
        this.date_of_join = date_of_join;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getFirst_Name() {
        return first_Name;
    }

    public String getLast_Name() {
        return last_Name;
    }

    public String getEmail() {
        return email;
    }

    public String getDepartment() {
        return department;
    }

    public String getDesignation() {
        return designation;
    }

    public Double getSalary() {
        return salary;
    }

    public LocalDate getDate_of_join() {
        return date_of_join;
    }

    public boolean isActive() {
        return active;
    }




}
