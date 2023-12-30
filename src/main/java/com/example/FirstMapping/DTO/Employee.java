package com.example.FirstMapping.DTO;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Data
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue
    private Long id;

    private String FirstName;

    private String LastName;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    private List<Certificates> certificatesList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public List<Certificates> getCertificatesList() {
        return certificatesList;
    }

    public void setCertificatesList(List<Certificates> certificatesList) {
        this.certificatesList = certificatesList;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", certificatesList=" + certificatesList +
                '}';
    }
}
