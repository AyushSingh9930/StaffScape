package com.ems_api.repository;

import com.ems_api.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>
{
    @Query("SELECT e FROM Employee e WHERE " +
            "LOWER(e.first_Name) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(e.last_Name) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(e.email) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(e.department) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(e.designation) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    public List<Employee> getEmployeesByKeyword(@Param("keyword") String keyword);
}
