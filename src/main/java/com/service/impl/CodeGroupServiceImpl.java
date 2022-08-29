package com.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.entity.Code;
import com.entity.CodeGroup;
import com.repository.CodeGroupRepository;
import com.repository.CodeRepository;
import com.service.CodeGroupService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CodeGroupServiceImpl implements CodeGroupService{
	@Autowired
	private CodeGroupRepository cgr;
	
	@Override
	public String insertCode() {
		cgr.deleteAll();
		CodeGroup first = 
				new CodeGroup("성별코드","test");
		first.setCodeGroupCd("01");
		first.addCode(new Code("M","남"));
		first.addCode(new Code("F","여"));
		
		CodeGroup second = 
				new CodeGroup("방문상태코드","test");
		second.setCodeGroupCd("02");
		second.addCode(new Code("1","방문중"));
		second.addCode(new Code("2","종료"));
		second.addCode(new Code("3","취소"));
		
		CodeGroup third = 
				new CodeGroup("진료과목코드","test");	
		third.setCodeGroupCd("03");
		third.addCode(new Code("01","내과"));
		third.addCode(new Code("02","안과"));
		
		CodeGroup fourth = 
				new CodeGroup("진료유형코드","test");
		fourth.setCodeGroupCd("04");
		fourth.addCode(new Code("D","약처방"));
		fourth.addCode(new Code("T","검사"));
		
		cgr.save(first);
		cgr.save(second);
		cgr.save(third);
		cgr.save(fourth);
		
		List<CodeGroup> list = cgr.findAll();
		
		String result="";
		for(CodeGroup c : list) {
			System.out.println(c.toString());
			result = c.getCodeGroupCd() + " " + c.getCodeGroupName();
		}		
		return result;
	}
}
