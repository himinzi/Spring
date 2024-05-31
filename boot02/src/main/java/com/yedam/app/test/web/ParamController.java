package com.yedam.app.test.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.emp.service.EmpVO;

// QueryString(질의문자열) : key=value&key=value&...
// method 는 상관없음.
// Content-type : application/x-www-form-urlencoded <--HTML Form 형태

@Controller
public class ParamController {
	
	// QueryString = 커맨드객체
	@RequestMapping(path="comobj", method= {RequestMethod.GET, RequestMethod.POST})
	
	@ResponseBody
	public String commandObject(EmpVO empVO) {
		String result = "";
		result += "path : / comobj\n";
		result += "\t employee_id : " + empVO.getEmployeeId();
		result += "\t last_name : " + empVO.getLastName();
		
		return result;
	}
	
	
	// QueryString => @RequestParam : 기본타입, 단일값
		@RequestMapping(path="reqparam", method= {RequestMethod.GET, RequestMethod.POST})
		
		@ResponseBody
		public String requestObject(@RequestParam Integer employeeId,  // 필수 (@RequestParam 의 여부에 따름)
													String lastName,   // 생략가능
									@RequestParam(name="message", defaultValue="No message", required = true) String msg) { // name 속성 사용하는 경우에는 msg 사용 x. message 라는 key 값 사용한다는 뜻
			String result = "";
			result += "path : / comobj\n";
			result += "\t employee_id : " + employeeId; // Required request parameter 'employeeId'
			result += "\t last_name : " + lastName;
			result += "\t message : " + msg;
			
			return result;
		} // 얘들은 command 객체처럼 아무것도 안 보내면 에러남. employeeId가 필수값이라서 null 이라도 넘겨야됨!
		
		// @PathVariable : 경로에 값을 포함하는 방식, 단일 값
		// Method 는 상관없음
		// Content-type 도 상관없음
		@RequestMapping("path/{id}") //  반드시 뭐든 값이 들어올때 써야 함. ex.path/Hong, path/1234
		@ResponseBody
		public String pathVariable(@PathVariable String id) {
			String result ="";
			result += "path : /path/{id} \n";
			result += "\t id : " + id;
			
			return result;
		}
		//@RequestBody : JSON 포멧, 배열 or 객체
		//Method : POST, PUT
		//Content-type : application/json =>보낼때 form 아님. json 임.
		@PostMapping("resbody")
		@ResponseBody
		public String requestBody(@RequestBody EmpVO empVO) {
			String result  = "path : \resbody \n";
			result += "\t employee_id : " + empVO.getEmployeeId();
			result += "\t last_name : " + empVO.getLastName();
			
			return result;
		}
		
		// List 타입
		@PostMapping("resbodyList")
		@ResponseBody
		public String requestBodyList(@RequestBody List<EmpVO> list) {
			String result ="path : /resbodyList \n";
			for(EmpVO empVO : list) {
				result += "\t employee_id : " + empVO.getEmployeeId();
				result += "\t last_name : " +empVO.getLastName();
			}
			return result;
		}
		
		
		
		


}
