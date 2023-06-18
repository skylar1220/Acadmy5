package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

	@GetMapping("/test")
	public String test() {
		return "formtest";
	}
	
	@GetMapping("/modaltest")
	public String modaltest() {
		return "modal";
	}
}
