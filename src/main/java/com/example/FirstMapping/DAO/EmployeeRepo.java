package com.example.FirstMapping.DAO;

import com.example.FirstMapping.DTO.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Long> {
}
