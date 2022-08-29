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

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name="CODE_GROUP")
public class CodeGroup {
	@Id
	@Column(name="CODE_GROUP_CD")
    private String codeGroupCd;
	@Column(name="CODE_GROUP_NAME")
    private String codeGroupName;
	@Column(name="COMMENT")
    private String comment;
    
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="CODE_GROUP_CD")
	private Collection<Code> codes;
	
    @Builder
    public CodeGroup(String codeGroupName, String comment) {
        this.codeGroupName = codeGroupName;
        this.comment = comment;
    }
    
	public void addCode(Code code){
		if( codes == null ){
			codes = new ArrayList<Code>();
		}
		codes.add(code);
	}
}
