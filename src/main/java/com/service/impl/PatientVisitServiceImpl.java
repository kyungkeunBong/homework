package com.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.entity.Code;
import com.entity.Patient;
import com.entity.PatientVisit;
import com.repository.CodeRepository;
import com.repository.PatientRepository;
import com.repository.VisitRepository;
import com.service.PatientVisitService;

import lombok.RequiredArgsConstructor;
import vo.PatientVisitVO;

@Service
@RequiredArgsConstructor
public class PatientVisitServiceImpl implements PatientVisitService{

	final private VisitRepository vr;
	final private CodeRepository cr;
	final private PatientRepository pr;
	
	@Override
	public String insert() {
		System.out.println("insertPatient");
		vr.deleteAll();
		ArrayList<PatientVisit> list = new ArrayList<>();
		PatientVisitVO vo  = new PatientVisitVO();
		for(int i=0; i<100; i++) {			
			vo.setHospitalID(1l);
			vo.setPatientId((i%10) + 1l);
			vo.setRegDate(new Date());
			vo.setVisitGroupCd("02");
			if(i%3 == 1) {
				vo.setVisitStatCd("1");
			}else if(i%3 == 2){
				vo.setVisitStatCd("2");
			}else {
				vo.setVisitStatCd("3");
			}
			
			list.add(new PatientVisit(vo.getRegDate(), 
					vo.getVisitGroupCd(), 
					vo.getVisitStatCd(),
					vo.getHospitalID(),
					vo.getPatientId()));
		}
		
		vr.saveAll(list);
		
		return "return Patient visit save success count " + list.size();
	}

	@Override
	public String update() {
		PatientVisit target = vr.getById(4l);
		String before = target.getVisitStatCd();
		Code beforeCode = cr.getOne(before);
		long time = new Date().getTime();
		if(time % 3 == 1) {
			target.setVisitStatCd("1");
		}else {
			target.setVisitStatCd("3");
		}
				
		vr.save(target);
		target = vr.getById(4l);
		String after = target.getVisitStatCd();
		Code afterCode = cr.getOne(after);
		return "update success change name " + beforeCode.getCodeName() + "->" + afterCode.getCodeName();
	}

	@Override
	public List<PatientVisit> search() {
		return vr.findAll();
	}
	@Override
	public List<Patient> searchPatient() {
		return pr.findAll();
	}

	@Override
	public String delete() {
		vr.deleteAll();
		return "detele success";
	}
}
