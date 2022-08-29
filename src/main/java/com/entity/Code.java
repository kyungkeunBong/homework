package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name="CODE")
public class Code {
	@Id
	@Column(name="CODE_CD")
    private String codeCd;
	@Column(name="CODE_NAME")
    private String codeName;
	@Column(name="CODE_GROUP_CD")
    private String codeGroupCd;
    
    @Builder
    public Code(String codeCd, String codeName) {
        this.codeCd = codeCd;
        this.codeName = codeName;
    }
}
