package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Code;
import com.entity.CodeGroup;
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
		System.out.println("insert Hospital");
		hr.deleteAll();
		Hospital first = new Hospital("병원1","1111","원장1");
		
		
		hr.save(first);
		
		List<Hospital> list = hr.findAll();
		
		for(Hospital c : list) {
			System.out.println(c.toString());			
		}
		return "return Hospital Id : " + list.get(0).getHospitalID();
	}
}
