package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.Code;
import com.entity.CodeGroup;
import com.entity.Patient;
import com.entity.PatientVisit;

public interface VisitRepository extends JpaRepository<PatientVisit, Long>{}
