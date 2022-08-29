package com.ctrl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.service.CodeGroupService;
import com.service.HospitalService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class HospitalController {
	
	private final HospitalService hospitalService;
	
	@RequestMapping(method=RequestMethod.GET , value="/hospital")
	public String insertHospital() {
		return hospitalService.insertHospital();
	}
}

