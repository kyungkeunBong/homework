package vo;


import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PatientVisitVO {	
	private long hospitalID;
	private long patientId;
	private Date regDate;
	private String visitGroupCd;
	private String visitStatCd;	
}
