package com.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name="PATIENT")
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name="PATIENT_ID") // key
    private long patientId;
	@Column(name="HOSPITAL_ID")
    private long hospitalID;
	@Column(name="PATIENT_NAME")
    private String patientName;
	@Column(name="PATIENT_REG_NO")
    private String patientRegNo;
	@Column(name="PATIENT_GENDER_GROUP_CD")
    private String patientGenderGroupCd;
	@Column(name="PATIENT_GENDER_CD")
    private String patientGenderCd;
	@Column(name="PATIENT_BIRTHDATE")
    private String patientBirthDate;
	@Column(name="PATIENT_TEL_NO")
    private String patientTelno;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="PATIENT_ID")
	private Collection<PatientVisit> visits;
    
    @Builder
    public Patient(String patientName, String patientRegNo,
   		 String patientGenderGroupCd, String patientGenderCd, String patientBirthDate, 
   		 String patientTelno, long hospitalID){ 
        this.patientName = patientName;
        this.patientRegNo = patientRegNo;
        this.patientGenderGroupCd = patientGenderGroupCd;
        this.patientGenderCd = patientGenderCd;
        this.patientBirthDate = patientBirthDate;
        this.patientTelno = patientTelno;
        this.hospitalID = hospitalID;
    }
	public void addPatientVisit(PatientVisit visit){
		if( visits == null ){
			visits = new ArrayList<PatientVisit>();
		}
		visits.add(visit);
	}
}
