package com.example.FirstMapping.Controller;

import com.example.FirstMapping.DTO.Certificates;
import com.example.FirstMapping.Service.CertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
    @RestController
    @RequestMapping("/certificates")
    public class CertificateController {

        @Autowired
        private CertificateService certificateService;

        @PostMapping("/{employeeId}")
        public ResponseEntity<Certificates> saveCertificate(
                @PathVariable Long employeeId, @RequestBody Certificates certificate) {
            Certificates savedCertificate = certificateService.saveCertificates(employeeId, certificate);
            return new ResponseEntity<>(savedCertificate, HttpStatus.CREATED);
        }

        @PutMapping("/{certificateId}")
        public ResponseEntity<Certificates> updateCertificate(
                @PathVariable Long certificateId, @RequestBody Certificates updatedCertificate) {
            Certificates updated = certificateService.updateCertificate(certificateId, updatedCertificate);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteCertificate(@PathVariable Long id) {
            certificateService.deleteCertificate(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        @GetMapping("/employee/{employeeId}")
        public ResponseEntity<List<Certificates>> getAllCertificatesForEmployee(
                @PathVariable Long employeeId) {
            List<Certificates> certificates = certificateService.getAllCertificatesofEmployeeById(employeeId);
            return new ResponseEntity<>(certificates, HttpStatus.OK);
        }
    }


