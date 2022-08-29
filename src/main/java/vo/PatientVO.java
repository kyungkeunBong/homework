package vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PatientVO {
	private String patientName;
	private String patientRegNo;
	private String patientGenderCd;
	private String patientGroupCd;
	private String patientBirthDate;
	private String patientTelno;
	
	private long hospitalID;
}
