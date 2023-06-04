package com.example.demo.question;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

/**
 * 
 * html 형식의 코드를 템플릿으로 해서 view 로 사용하는데
 * 이때 사용되는 엔진중에 타임리프(Thymleaf)
 * Velocity와 같은 다른 엔진도 사용 - 스프링 레거시 - jsp
 *
 */
@RequestMapping("/question")
@RequiredArgsConstructor
@Controller
public class QuestionController {
//	@Autowired
//	QuestionRepository question;
	
	private final QuestionService questionService;
	

	@PostMapping("/create" )
	public String create(@Valid Question question , BindingResult bindingResult) {
		if(!bindingResult.hasErrors()) {
//			Question question = new Question();
//			question.setSubject(questionForm.getSubject());
//			question.setContent(questionForm.getContent());
			questionService.create(question);
		}
		return "redirect:/question/list";
	}
	
	@GetMapping("/list")
//	@ResponseBody
	public String list(Model model) {
		List<Question> questionLists =  questionService.getList();
		model.addAttribute("qlist", questionLists);		
		return "question_list";
	}
	
	
	@GetMapping("/detail/{id}")
	public String detail(Model model, @PathVariable("id") Integer id) {
		Question qeustion =  questionService.getDetail(id);
		model.addAttribute("question", qeustion);
		return "qeustion_detail";
	}
	

}
