package com.example.demo.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.ItemDto;

@Controller
@RequestMapping(value = "/shop")
public class ShopController {

	@GetMapping("/test1")
	public String test1(Model model) {
		model.addAttribute("data", "반가워요.");
		return "test/test1";
	}
	// itemdto에 데이터 담아서 화면에 출력
	@GetMapping("/test2")
	public String test2(Model model) {
		List<ItemDto> lists = new ArrayList<ItemDto>();
		for (int i = 0; i < 10; i++) {
			ItemDto id = new ItemDto();
			id.setItemNm("핸드폰 "+i);
			id.setItemDetail("들고 다니는거 " + i);
			id.setPrice(1200000 + Integer.valueOf(i));
			id.setRegTime(LocalDateTime.now());
			id.setUpdateTime(LocalDateTime.now());
			lists.add(id);			
		}
		model.addAttribute("itemDtoList", lists);
		return "test/test2";
	}
	
	@GetMapping("/test3")
	public String test3( Model model, String param1, String param2) {
		System.out.println("param1: " + param1 + " param2: " + param2);
		return "test/test2";
	}
	
	@GetMapping("/test4")
	public String test3( ) {
		return "test/test3";
	}
}
