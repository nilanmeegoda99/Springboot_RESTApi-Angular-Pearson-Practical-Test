package com.coronapatients.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coronapatients.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

}
