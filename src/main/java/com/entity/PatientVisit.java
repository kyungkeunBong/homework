package com.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
@Entity(name="VISIT_PATIENT")
public class PatientVisit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name="PATIENT_VISIT_ID") // key
    private long patientVisitId;
	@Column(name="HOSPITAL_ID")
    private long hospitalID;
	@Column(name="PATIENT_ID ")
    private long patientId;
	@Column(name="REG_DATE")
    private Date regDate;
	@Column(name="VISIT_STAT_CD")
    private String visitStatCd;
    
    @Builder
    public PatientVisit(Date regDate, String visitStatCd) {
        this.regDate = regDate;
        this.visitStatCd = visitStatCd;
    }
}
