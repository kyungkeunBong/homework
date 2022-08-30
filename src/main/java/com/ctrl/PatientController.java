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
	
	@RequestMapping(method=RequestMethod.GET , value="/patient/addAct5")
	public String insertAct5() {
		return patientService.insertAct5();
	}
	@RequestMapping(method=RequestMethod.GET , value="/patient/updateAct5")
	public String updateAct5() {
		return patientService.updateAct5();
	}
	@RequestMapping(method=RequestMethod.GET , value="/patient/deleteAct5")
	public String deleteAct5() {
		return patientService.deleteAct5();
	}
	@RequestMapping(method=RequestMethod.GET , value="/patient/readAct5")
	public Patient searchAct5() {
		return patientService.searchAct5();
	}
	@RequestMapping(method=RequestMethod.GET , value="/patient/readAllAct5")
	public List<Patient> searchAllAct5() {
		return patientService.searchAllAct5();
	}
	@RequestMapping(method=RequestMethod.GET , value="/patient/queryDslRead")
	public List<Patient> findbyInput() {
		return patientService.findbyInput("봉경근", "봉경근등록번호", "봉경근생일");
	}
	
	@RequestMapping(method=RequestMethod.GET , value="/patient/queryDslPage")
	public List<Patient> findPage() {
		return patientService.findPage();
	}
}

