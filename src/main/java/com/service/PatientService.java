package com.service;

import java.util.List;

import com.entity.Patient;

public interface PatientService {
	public String insert();
	public String update();
	public List<Patient> search();
	public String delete();
}
