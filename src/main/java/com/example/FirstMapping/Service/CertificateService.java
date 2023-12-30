package com.example.FirstMapping.Service;

import com.example.FirstMapping.DAO.CertificateRepo;
import com.example.FirstMapping.DAO.EmployeeRepo;
import com.example.FirstMapping.DTO.Certificates;
import com.example.FirstMapping.DTO.Employee;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CertificateService {
    @Autowired
     private   CertificateRepo certificateRepo;
    @Autowired
    private EmployeeRepo employeeRepo;
    @Transactional
    public Certificates saveCertificates(Long id , Certificates certificate){
        Optional<Employee> employee= employeeRepo.findById(id);
        Employee Exemployee=null;
                                                 //.orElseThrow(()-> new EntityNotFoundException("Employee not Found with id "+ id));
        if(employee.isPresent()){
            Exemployee=employee.get();
        certificate.setEmployee(Exemployee);

    }
        return certificateRepo.save(certificate);
    }
    public Certificates updateCertificate(Long certifucateid,Certificates certificate){
        Optional<Certificates> exsistingcertificates= certificateRepo.findById(certifucateid);
        if(exsistingcertificates.isPresent()){
            Certificates ExsitingOne= exsistingcertificates.get();
            ExsitingOne.setName(certificate.getName());
        }
        return certificateRepo.save(certificate);
    }
    public void deleteCertificate(Long id){
        Optional<Certificates> exsistingcertificates= certificateRepo.findById(id);
        if(exsistingcertificates.isPresent()){
            Certificates ExsitingOne= exsistingcertificates.get();
           certificateRepo.delete(ExsitingOne);
        }
    }
    public List<Certificates> getAllCertificatesofEmployeeById(Long id){
       Optional<Employee> Exsitingeployee= employeeRepo.findById(id);
        Employee Exsiting=null;
       if(Exsitingeployee.isPresent()){
            Exsiting=Exsitingeployee.get();
         //  return Exsiting.getCertificatesList();
       }

        return Exsiting.getCertificatesList();
    }


}
