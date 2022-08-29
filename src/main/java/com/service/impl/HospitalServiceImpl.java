package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Hospital;
import com.repository.HospitalRepository;
import com.service.HospitalService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HospitalServiceImpl implements HospitalService{

	@Autowired
	private HospitalRepository hr;
	
	@Override
	public String insertHospital() {
		System.out.println("insertHospital");
		hr.deleteAll();
		Hospital first = new Hospital("병원1","1111","원장1");
		Hospital second = new Hospital("병원2","2222","원장2");
		Hospital third = new Hospital("병원3","3333","원장3");
		
		hr.save(first);
		hr.save(second);
		hr.save(third);
		
		List<Hospital> list = hr.findAll();
		
		for(Hospital c : list) {
			System.out.println(c.toString());			
		}
		return "return Hospital Id : " + list.get(0).getHospitalID();
	}
}
