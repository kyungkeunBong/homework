package com.service;

import java.util.List;

import com.entity.Patient;
import com.entity.PatientVisit;

public interface PatientVisitService {
	public String insert();
	public String update();
	public List<PatientVisit> search();
	public String delete();
	public List<Patient> searchPatient();
	
}
