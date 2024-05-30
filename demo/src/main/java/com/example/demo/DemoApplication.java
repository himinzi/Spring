package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // = @SpringBootConfiguration + @EnableAutoConfiguration + @ComponentScan // xml 대신 annotation 을 씀
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args); // 자기자신의 정보를 넘기고 있음.
	}

}
// 위치 이동X, 코드 추가X, 약간 react 의 index 같음