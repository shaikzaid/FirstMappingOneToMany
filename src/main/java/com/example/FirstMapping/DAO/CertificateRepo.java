package com.example.FirstMapping.DAO;

import com.example.FirstMapping.DTO.Certificates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificateRepo extends JpaRepository<Certificates , Long> {
}
