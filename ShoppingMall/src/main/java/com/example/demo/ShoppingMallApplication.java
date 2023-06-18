package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.ItemRepository;
//@RestController
@SpringBootApplication
// @ComponentScan(basePackages = {"com.example.demo", "com.example.repository"}) -> 다음주에 변경 예정
public class ShoppingMallApplication {
	@Autowired
	ItemRepository ir;
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(ShoppingMallApplication.class, args);
	}

//	@GetMapping("/")
//	public UserDto start() {
//		System.out.println(ir);
//		UserDto d = new UserDto();
//		d.setAge(10);
//		d.setName("홍길동");
//		return d;
//	}
}
