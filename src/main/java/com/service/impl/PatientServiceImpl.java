package com.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.entity.Hospital;
import com.entity.Patient;
import com.entity.QPatient;
import com.querydsl.core.QueryResults;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.repository.HospitalRepository;
import com.repository.PatientRepository;
import com.service.HospitalService;
import com.service.PatientService;

import lombok.RequiredArgsConstructor;
import vo.PatientVO;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService{

	final private PatientRepository pr;
	final private HospitalRepository hr;
	private final JPAQueryFactory queryFactory;
	@Override
	public String insert() {
		System.out.println("insertPatient");
		pr.deleteAll();
		ArrayList<Patient> list = new ArrayList<>();
		
		PatientVO vo  = new PatientVO();
		List<Hospital> hos = hr.findAll();
		for(int i=0; i<100; i++) {			
			vo.setPatientName("환자" + String.valueOf(i));
			vo.setPatientRegNo("등록번호" + String.valueOf(i));
			vo.setPatientGroupCd("01"); // 성별코드
			if(i%2 ==1) {
				vo.setPatientGenderCd("M");
			}else {
				vo.setPatientGenderCd("F");
			}
			
			if(i%3 == 1) {
				vo.setHospitalID(hos.get(0).getHospitalID());
			}else if(i%3 == 2) {
				vo.setHospitalID(hos.get(1).getHospitalID());
			}else {
				vo.setHospitalID(hos.get(2).getHospitalID());
			}
			vo.setPatientBirthDate("20220829");
			vo.setPatientTelno("010-1111-111"+String.valueOf(i));
			
			if(i==99) {
				list.add(new Patient("봉경근", 
						"봉경근등록번호", 
						vo.getPatientGroupCd(), 
						vo.getPatientGenderCd(), 
						"봉경근생일", 
						vo.getPatientTelno(),
						vo.getHospitalID()));
				
			}else {
				list.add(new Patient(vo.getPatientName(), 
						vo.getPatientRegNo(), 
						vo.getPatientGroupCd(), 
						vo.getPatientGenderCd(), 
						vo.getPatientBirthDate(), 
						vo.getPatientTelno(),
						vo.getHospitalID()));
			}
			
		}
		
		pr.saveAll(list);
		
		return "return Patient save success count " + list.size();
	}

	@Override
	public String update() {
		List<Patient> list = pr.findAll();
		Patient target = pr.getById(list.get(0).getHospitalID());
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
	
	@Override
	public String insertAct5() {
		System.out.println("insertPatient");
		pr.deleteAll();
		ArrayList<Patient> list = new ArrayList<>();
		
		PatientVO vo  = new PatientVO();
		for(int i=0; i<100; i++) {			
			vo.setPatientName("환자" + String.valueOf(i));			
			vo.setPatientGroupCd("01"); // 성별코드
			String hoscode="";
			List<Hospital> hos = hr.findAll();
			if(i%3==1){
				vo.setPatientGenderCd("M");
				hoscode = "1번병원";
				vo.setHospitalID(hos.get(0).getHospitalID());
			}else if(i%3 ==2) {
				vo.setPatientGenderCd("F");
				hoscode = "2번병원";
				vo.setHospitalID(hos.get(1).getHospitalID());
			}else {
				vo.setPatientGenderCd("M");
				hoscode = "3번병원";
				vo.setHospitalID(hos.get(2).getHospitalID());
			}
			
			vo.setPatientRegNo(hoscode + "등록번호" + String.valueOf(i));
			vo.setPatientBirthDate("20220829");
			vo.setPatientTelno("010-1111-111"+String.valueOf(i));
			
			list.add(new Patient(vo.getPatientName(), 
					vo.getPatientRegNo(), 
					vo.getPatientGroupCd(), 
					vo.getPatientGenderCd(), 
					vo.getPatientBirthDate(), 
					vo.getPatientTelno(),
					vo.getHospitalID()));
		}
		
		pr.saveAll(list);
		
		return "return Patient save success count " + list.size();
	}
	
	@Override
	public String updateAct5() {
		List<Patient> list = pr.findAll();
		Patient target = pr.getById(list.get(0).getPatientId());
		String before = target.getPatientName();
		String telNo = target.getPatientTelno();
		target.setPatientName("바꾸자이름");
		target.setPatientTelno(String.valueOf(new Date().getTime()));
		pr.save(target);
		target = pr.getById(list.get(0).getPatientId());
		return "update success change name " + before + " " + telNo + " " + "->" + 
				target.getPatientName() + " " + target.getPatientTelno();
	}
	
	@Override
	public String deleteAct5() {
		List<Patient> list = pr.findAll();
		Patient target = pr.getById(list.get(0).getPatientId());
		pr.delete(target);
		return "detele success patient id : " + list.get(0).getPatientId() ;
	}
	
	@Override
	public Patient searchAct5() {
		List<Patient> list = pr.findAll();
		return pr.getById(list.get(0).getPatientId());
	}
	
	@Override
	public List<Patient> searchAllAct5() {
		return pr.findAll();
	}

	@Override
	public List<Patient> findbyInput(String pName, String pregNo, String pBirth) {
		QPatient qPatient = QPatient.patient;
		return queryFactory.selectFrom(qPatient)
				.where(
						qPatient.patientName.eq(pName)
						.and(qPatient.patientRegNo.eq(pregNo)
						.and(qPatient.patientBirthDate.eq(pBirth)))
						).fetch();
	}
	
	@Override
	public List<Patient> findPage() {
		QPatient qPatient = QPatient.patient;
		Pageable pageable = PageRequest.of(0, 10);
		QueryResults<Patient> result = 
				queryFactory.selectFrom(qPatient)
				.offset(pageable.getOffset())
				.limit(pageable.getPageSize())
				.fetchResults();
		
		long total  = result.getTotal(); // 전체개수
		System.out.println("#### 총 갯수는 : "  + total);
		return result.getResults();
	}
}
