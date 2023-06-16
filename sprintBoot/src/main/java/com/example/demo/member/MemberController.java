package com.example.demo.member;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/member")
public class MemberController {
	private final MemberService memberService;
	
	// 회원가입 - 사용자에게 정보받아서 Member 테이블에 insert
	@GetMapping("/signup")
	public String signup(MemberForm memberForm) {		
		return "signup";
	}
	
	@PostMapping("/signup")
	public String signupPost(@Valid MemberForm memberForm, BindingResult bindingResult) {		
		if(bindingResult.hasErrors()) {			
			return "signup";
		}
		if(!memberForm.getPassword().equals(memberForm.getConfirmPassword())) {
			bindingResult.rejectValue("confirmPassword","passwordInCorrect","패스워드가 일치하지 않습니다.");			
			return "signup";
		}
		Member member = new Member();
		member.setEmail(memberForm.getEmail());
		member.setPassword(memberForm.getPassword());
		member.setUserName(memberForm.getUserName());
		
		try {
			memberService.create(member);			
		} catch (DataIntegrityViolationException e) {
			e.printStackTrace();
			bindingResult.rejectValue("email", "emailTwice", "이메일이 중복되었습니다.");
			return "signup";
		}catch (Exception e) {
			e.printStackTrace();
			bindingResult.rejectValue("signupFailed", "signupFailed..", e.getMessage());
			return "signup";
		}
		
		return "redirect:/";
	}
	// 로그인 페이지 호출
	@GetMapping("/signin")
	public String signin() {		
		return "signin";
	}
	@PostMapping("/signin")
	public String signinPost(@RequestParam(value = "email") String email,
			@RequestParam(value = "password") String password
			, HttpServletRequest req) {		
		HttpSession session =  req.getSession();
		Member member =  memberService.findByEmail(email,password);
		// 로그인 성공		
		if(member != null) {
			session.setAttribute("member", member);
			return "redirect:/";
		} 
		else {
			return "signin";
		}
	}
	@GetMapping("/signout")
	public String signout(HttpServletRequest req) {
		HttpSession session = req.getSession();
		session.invalidate();
		return "redirect:/";
	}

}
