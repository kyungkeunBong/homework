package com.ctrl;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Patient;
import com.service.CodeGroupService;
import com.service.HospitalService;
import com.service.PatientService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class PatientController {
	
	private final PatientService patientService;
	
	@RequestMapping(method=RequestMethod.GET , value="/patient/add")
	public String insert() {
		return patientService.insert();
	}
	@RequestMapping(method=RequestMethod.GET , value="/patient/update")
	public String update() {
		return patientService.update();
	}
	@RequestMapping(method=RequestMethod.GET , value="/patient/read")
	public List<Patient> search() {
		return patientService.search();
	}
	@RequestMapping(method=RequestMethod.GET , value="/patient/delete")
	public String delete() {
		return patientService.delete();
	}
}

