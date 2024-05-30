package com.yedam.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpVO;

@SpringBootTest // junit 과 spring 을 연결하는 annotation
class Boot02ApplicationTests {
	
	@Autowired
	EmpMapper empMapper;
	
	//@Test
	public void empList() {
		List<EmpVO> list = empMapper.selectEmpAll();
		assertTrue(!list.isEmpty());  // list 는 안에 값이 없어도 null 이 아님 -> empty 로 체크
		// assertTrue : 내부에 있는 조건식이 true 인 경우 찾기
	}
	
	//@Test
	public void empInfo() {
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(100);
		
		EmpVO findVO = empMapper.selectEmpInfo(empVO);
		assertEquals(findVO.getLastName(), "King"); // 2개의 값을 비교해서 같은지, 정상적으로 코드와 맞으면 단위테스트 성공!
	}
	
	//@Test
	public void empInsert() {
		EmpVO empVO = new EmpVO();
		empVO.setLastName("Hong");
		empVO.setEmail("kgaaHong@google.com");
		empVO.setJobId("IT_PROG");
		
		int result = empMapper.insertEmpInfo(empVO);
		
		System.out.println(empVO.getEmployeeId());
		assertEquals(result, 1);
	}
	
	//@Test
	public void empUpdate() {
		// 1) 대상조회
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(209);
		
		EmpVO findVO = empMapper.selectEmpInfo(empVO);
		System.out.println(findVO);
		
		// 2) 정보 수정
		findVO.setLastName("Kang");
		int result = empMapper.updateEmpInfo(findVO.getEmployeeId(), findVO);
		assertEquals(result, 1);
	}
	
	//2개를 동시에 테스트할 경우 순서는 보장되지 않음
	@Test
	public void empDelete() {
		int result = empMapper.deleteEmpInfo(1002);
		assertEquals(result, 1);
	}

}
