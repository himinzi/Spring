package com.yedam.app.emp.service;

import java.util.List;
import java.util.Map;

// 사용자에게 제공하는 기능
public interface EmpService {
	
	// 전체 사원정보 조회
	public List<EmpVO> empList();
	
	// 사원정보 조회
	public EmpVO empInfo(EmpVO empVO);
	
	// 사원정보 등록
	public int empInsert(EmpVO empVO);
	
	// 사원정보 수정
	public Map<String, Object> empUpdate(EmpVO empVO);
	
	// 사원정보 삭제 Mapper 는 DB 접근 용도, Service 는 사용자에게 제공할 용도
	public Map<String, Object> empDelete(EmpVO empVO);
	
}
