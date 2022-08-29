package com.service;

import java.util.List;

import com.entity.Patient;

public interface PatientService {
	public String insert();
	public String update();
	public List<Patient> search();
	public String delete();
	public String insertAct5();
	public String updateAct5();
	public String deleteAct5();
	public Patient searchAct5();
	public List<Patient> searchAllAct5();
}
