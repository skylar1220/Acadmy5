package com.example.demo.user;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor	// service 쓰니까
@Controller
@RequestMapping("/member")
public class MemberController {
	private final MemberService memberService;		// 이제 new이런 거 없어도 객체 생성~
	
	// 회원가입 - 사용자에게 정보 받아서 Member 테이블에 insert
	@GetMapping("/signup") 	// 최초 화면 보여줄 때는 들고오는 정보 없으니 get 방식
	public String signup(MemberForm memberForm) {	// 이렇게 하면 스프링부트가 알아서 화면에 정보를 넣어줌
		return "signup";
	}
	
	@PostMapping("/signup")  
	public String signupPost(@Valid MemberForm mf, BindingResult bindingResult) { 
		if(bindingResult.hasErrors()) {
			return "signup";	// 다시 signup 보여줄 때 bindingResult이 오류 정보를 갖고오므로 redirect 하면 x
		}
		if(!mf.getPassword().equals(mf.getConfirmPassword())) {
			bindingResult.rejectValue("confirmPassword", "passwordIncorrect", "패스워드가 일치하지 않습니다.");
			return "signup";
		}
		Member member = new Member();
		member.setEmail(mf.getEmail());
		member.setPassword(mf.getPassword());
		member.setUserName(mf.getUserName());
		memberService.create(member);
		return "redirect:/";
	}
	
	// 회원탈퇴 - 삭제
	
	// 로그인 - 조회했는데, 성공
	
	// 로그아웃 - 
}
