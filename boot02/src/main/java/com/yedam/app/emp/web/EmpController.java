package com.yedam.app.emp.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

@Controller // => 사용자의 요청(End point)에 대한 처리
			// : url + method => service => view
public class EmpController {
	// Controller 는 결국 web 에서 하기땜스 package 명을 web 으로 지어야 됨!
	// 해당 컨트롤러에서 제공하는 서비스들 추가
	@Autowired
	EmpService empService;
	
	// GET : 조회, 빈페이지 - 정말 제한적!!!! 검색할때 빼곤 데이터 넘기는 거 잘 없음
	// POST : 데이터 조작 (등록, 수정, 삭제)
	
	// 전체조회 : GET
	@GetMapping("empList")
	public String empList(Model model) { // Model = Request + Response
		// 1) 해당 기능 수행 -> Service
		List<EmpVO> list = empService.empList();
		
		// 2) 클라이언트에 전달할 데이터 담기
		model.addAttribute("empList", list); // 별도로 return 하지 않아도 전달 받음. 
		
		return "emp/list"; // 3) 데이터를 출력할 페이지 결정. return 시 절대! 앞에 / 붙으면 안 됨! (이미 template 에 / 붙어있음)
		// classpath:/templates/  	emp/list  .html
		// prefix					 return   subfix
	}
	
	// 단건조회 : GET
	@GetMapping("empInfo")
	public String empInfo(EmpVO empVO, Model model) {
		// 1) 해당 기능 수행 -> Service
		EmpVO findVO = empService.empInfo(empVO);
		// 2) 클라이언트에 전달할 데이터 담기
		model.addAttribute("empInfo", findVO); // 별도로 return 하지 않아도 전달 받음. 
		return "emp/info"; // 3) 데이터를 출력할 페이지 결정
	}
	
	// 등록 -> 페이지 : GET // 페이지만 요청하기 때문에 심플, service 가 없음.
	@GetMapping("empInsert")
	public String empInsertForm() {
		return "emp/insert";
	}
	
	// 등록 -> 처리 : POST // 페이지와 같은 경로를 씀.메소드(get/post)로 구분 => form 태그를 통한 submit
	@PostMapping("empInsert")
	public String empInsertProcess(EmpVO empVO) { // form tag 이용? ajax 이용?
		int eid = empService.empInsert(empVO);
		String url = null;
		if(eid > -1) {
			// 정상적으로 등록된 경우
			url = "redirect:empInfo?employeeId="+eid; // redirect: 오타나면 안 됨 (page 가 아니라 controller 를 호출해야 됨을 인지 시키기 위해)
		}else {
			// 정상적으로 등록되지 않은 경우
			url = "redirect:empList";
		}
		
		return url;
	}
	
	// 수정 -> 페이지 : GET
	@GetMapping("empUpdate")
	public String empUpdateForm(Integer employeeId, Model model) {
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(employeeId);
		
		EmpVO findVO = empService.empInfo(empVO);
		model.addAttribute("empInfo", findVO);
		return "emp/update"; 
	}
	
	// 수정 -> 처리 : AJAX (수정은 대부분 ajax 로 처리하는 경우가 많음. 잘못된 수정이 있으면 바로 변경하기 위해) => QueryString
	@PostMapping("empUpdate")
	@ResponseBody // => AJAX
	public Map<String, Object> empUpdateAJAXQueryString(EmpVO empVO){
		return empService.empUpdate(empVO);
	}
	
	// 수정 -> 처리 : AJAX => JSON (@RequestBody) : json 과 queryString 차이점
	@ResponseBody // => AJAX
	public Map<String, Object> empUpdateAJAXJSON(@RequestBody EmpVO empVO){
		return empService.empUpdate(empVO);
	}
	
	// 삭제 -> 처리
	@GetMapping("empDelete")
	public String empDelete(EmpVO empVO) {
		empService.empDelete(empVO);
		return "redirect:empList"; // delete 는 삭제되어버린 것이니, 페이지를 바꿔버림.
	}

}
