package com.yedam.app.emp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.app.emp.service.EmpVO;

public interface EmpMapper {
	// 전체조회
	public List<EmpVO> selectEmpAll(); // 이름짓는 법 : select 대상 여러건이냐?
	
	// 단건조회
	public EmpVO selectEmpInfo(EmpVO empVO);
	
	// 등록
	public int insertEmpInfo(EmpVO empVO);
	
	// 수정, Param은 mybatis꺼! 매개변수 2개 이상일때 부터 씀. param안의 이름은 꼭 활용하기
	public int updateEmpInfo(@Param("eId")int empId, @Param("info")EmpVO empVO);
	
	// 삭제
	public int deleteEmpInfo(int empId);

}
