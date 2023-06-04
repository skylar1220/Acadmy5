package com.example.demo.answer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.question.Question;
import com.example.demo.question.QuestionService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/answer")
@Controller
public class AnswerController {
	
	// 생성자 주입방식으로 객체를 할당 받음 (recommand)
	private final AnswerService answerService;
	private final QuestionService questionService ; 
	
	@PostMapping("/create/{id}")
	public String create(@PathVariable("id") Integer id, @RequestParam String content) {
		Question question = questionService.getDetail(id);
		answerService.create(question, content);
		return "redirect:/question/detail/{id}";
	}
}
