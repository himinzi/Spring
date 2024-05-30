package com.yedam.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.yedam.app.**.mapper") // interface 담당!
// 안 해도 되는데, 안 하면 DAO랑 관련돼 있다고 하나하나 class 마다 알려줘야 됨. 
// 기능 상관 없이, 무조건 mapper package 밑으로 // 원래 중간에 쓰는 *은 2개 써야 됨!
public class Boot02Application {

	public static void main(String[] args) {
		SpringApplication.run(Boot02Application.class, args);
	}

}
