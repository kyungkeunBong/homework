package com.ctrl;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Patient;
import com.entity.PatientVisit;
import com.service.CodeGroupService;
import com.service.HospitalService;
import com.service.PatientService;
import com.service.PatientVisitService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class PatientVistController {
	
	private final PatientVisitService patientVisiteService;
	
	@RequestMapping(method=RequestMethod.GET , value="/visit/add")
	public String insert() {
		return patientVisiteService.insert();
	}
	@RequestMapping(method=RequestMethod.GET , value="/visit/update")
	public String update() {
		return patientVisiteService.update();
	}
	@RequestMapping(method=RequestMethod.GET , value="/visit/read")
	public List<PatientVisit> search() {
		return patientVisiteService.search();
	}
	@RequestMapping(method=RequestMethod.GET , value="/visit/readPatient")
	public List<Patient> searchPatient() {
		return patientVisiteService.searchPatient();
	}
	@RequestMapping(method=RequestMethod.GET , value="/visit/delete")
	public String delete() {
		return patientVisiteService.delete();
	}
}

