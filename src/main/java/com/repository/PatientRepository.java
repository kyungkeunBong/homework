package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.Code;
import com.entity.CodeGroup;
import com.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long>{}
