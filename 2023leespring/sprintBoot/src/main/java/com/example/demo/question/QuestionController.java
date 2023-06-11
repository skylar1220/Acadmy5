package com.example.demo.question;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.member.Member;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
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
	public String create(@Valid Question question , BindingResult bindingResult, HttpServletRequest req
			) {
		if(!bindingResult.hasErrors()) {
			HttpSession session = req.getSession();
			question.setMember((Member )session.getAttribute("member"));
			questionService.create(question);
			
		}
		return "redirect:/question/list";
	}
	
	@GetMapping("/list")
//	@ResponseBody
	public String list(Model model
			, @RequestParam(value = "page" , defaultValue = "0" ) int page,
			HttpServletRequest req
			) {	
		Page<Question> paging = questionService.getList(page);
		// paging.hasPrevious()
		// paging.getTotalPages();
		model.addAttribute("paging", paging);
		
		HttpSession session = req.getSession();
		if(session.getAttribute("member") != null) {
			model.addAttribute("isLogin", true);
		}
		return "question_list";
	}
	
	
	@GetMapping("/detail/{id}")
	public String detail(Model model, @PathVariable("id") Integer id) {
		Question qeustion =  questionService.getDetail(id);
		model.addAttribute("question", qeustion);
		return "qeustion_detail";
	}
	

}
