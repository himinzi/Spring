package com.yedam.app.emp.service;

import java.util.Date;

import lombok.Data;

@Data
public class EmpVO {
	private Integer employeeId; 
	// controller 에서 값을 받을 때, primary key 나 not null 제약조건이 있으면 Integer 를 씀. 데이터가 없는 경우에도 대응할 수 있도록!!
	// null 은 double, int 가 처리 할 수 없어서 error 가 남
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private Date hireDate;
	private String jobId;
	private double salary;
	private double commissionPct;
	private int managerId;
	private int departmentId;

}
