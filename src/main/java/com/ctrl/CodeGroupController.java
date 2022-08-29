package com.ctrl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.service.CodeGroupService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CodeGroupController {
	
	private final CodeGroupService codeGroupService;
	
	@RequestMapping(method=RequestMethod.GET , value="/code")
	public String insertCode() {		
		return codeGroupService.insertCode();
	}
}

