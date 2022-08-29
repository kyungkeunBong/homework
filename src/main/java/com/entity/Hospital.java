package com.entity;

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
import javax.persistence.SequenceGenerator;

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
@Entity(name="HOSPITAL")

public class Hospital {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="HOSPITAL_ID") // key
    private long hospitalID;
	@Column(name="HOSPITAL_NAME")
    private String hospitalName;
	@Column(name="IDENTIFICATION_NUMBER")
    private String identificationNumber;
	@Column(name="HOSPITAL_PRESIDENT_NAME ")
    private String hospitalPresidentName;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="HOSPITAL_ID")
	private Collection<PatientVisit> visits;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="HOSPITAL_ID")
	private Collection<Patient> patients;
    
    @Builder
    public Hospital(String hospitalName, String identificationNumber,
    		 String hospitalPresidentName){ 
        this.hospitalName = hospitalName;
        this.identificationNumber = identificationNumber;
        this.hospitalPresidentName = hospitalPresidentName;
    }
    
	public void addPatientVisit(PatientVisit visit){
		if( visits == null ){
			visits = new ArrayList<PatientVisit>();
		}
		visits.add(visit);
	}
	public void addPatient(Patient pacient){
		if( patients == null ){
			patients = new ArrayList<Patient>();
		}
		patients.add(pacient);
	}
}
