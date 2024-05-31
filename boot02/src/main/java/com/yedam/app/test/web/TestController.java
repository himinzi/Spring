package com.yedam.app.test.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // Actuator 추가함
public class TestController {
	// Controller 는 interface 필요 없음. (annotation 이 있기 때문)
	
//	@RequestMapping(path="/test", method=RequestMethod.GET) // 경로 등록, 밑에꺼랑 같은 의미
	@GetMapping("test") 
	@ResponseBody
	public String urlGetTest(String keyword) { // 질의 문자열 http://localhost:8080/test?keyword=Hello
		return "Server Response : SELECT - " + keyword;
	}
	
	
//	@RequestMapping(path="/test", method=RequestMethod.POST) // 경로 등록
	@PostMapping("test")
	@ResponseBody
	public String urlPostTest(String keyword) { 
		return "Server Response : INSERT - " + keyword;
	}
	
	
}
