package com.example.FirstMapping.Service;

import com.example.FirstMapping.DAO.EmployeeRepo;
import com.example.FirstMapping.DTO.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;

    public Employee saveEmployee(Employee employee){
        return employeeRepo.save(employee);
    }
    public Optional<Employee> getEmployeeById(Long id){
        return employeeRepo.findById(id);
    }
    public List<Employee> getAllEmployees(){
        return employeeRepo.findAll();
    }
//    public Employee getCertificateById(Long id){
//        return employeeRepo.
//    }
    public Employee updateEmployeeById(Long id , Employee updateEmployee){
        Optional<Employee> ExsistingEmployee= employeeRepo.findById(id);
        Employee ExsistingEmployee1 =null;
        if(ExsistingEmployee.isPresent()){
             ExsistingEmployee1 = ExsistingEmployee.get();
            ExsistingEmployee1.setFirstName(updateEmployee.getFirstName());
            ExsistingEmployee1.setLastName(updateEmployee.getLastName());
        }
        return employeeRepo.save(ExsistingEmployee1);
    }
    public void deleteEmployeeById(Long id){
      employeeRepo.deleteById(id);
    }
}
