package com.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Hospital;
import com.entity.Patient;
import com.repository.PatientRepository;
import com.service.HospitalService;
import com.service.PatientService;

import lombok.RequiredArgsConstructor;
import vo.PatientVO;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService{

	final private PatientRepository pr;
	
	@Override
	public String insert() {
		System.out.println("insertPatient");
		pr.deleteAll();
		ArrayList<Patient> list = new ArrayList<>();
		
		PatientVO vo  = new PatientVO();
		for(int i=0; i<100; i++) {			
			vo.setPatientName("환자" + String.valueOf(i));
			vo.setPatientRegNo("등록번호" + String.valueOf(i));
			vo.setPatientGroupCd("01"); // 성별코드
			if(i%2 ==1) {
				vo.setPatientGenderCd("M");
			}else {
				vo.setPatientGenderCd("F");
			}
			vo.setPatientBirthDate("20220829");
			vo.setPatientTelno("010-1111-111"+String.valueOf(i));
			
			list.add(new Patient(vo.getPatientName(), 
					vo.getPatientRegNo(), 
					vo.getPatientGroupCd(), 
					vo.getPatientGenderCd(), 
					vo.getPatientBirthDate(), 
					vo.getPatientTelno(),
					1l));
		}
		
		pr.saveAll(list);
		
		return "return Patient save success count " + list.size();
	}

	@Override
	public String update() {
		Patient target = pr.getById(4l);
		String before = target.getPatientName();
		target.setPatientName("바꾸자이름");
		pr.save(target);
		return "update success change name " + before + "->" + target.getPatientName();
	}

	@Override
	public List<Patient> search() {
		return pr.findAll();
	}

	@Override
	public String delete() {
		pr.deleteAll();
		return "detele success";
	}
}
