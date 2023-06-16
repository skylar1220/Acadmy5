package com.example.demo.member;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MemberService {	
	private final MemberRepository memberRepository;
	private final PasswordEncoder passwordEncoder;  
	
	public void create(Member member) {
		member.setPassword(passwordEncoder.encode(member.getPassword()));		
		memberRepository.save(member);		
	}


	public Member findByEmail(String email,String password) {
		Member member = memberRepository.findByEmail(email);
		if(passwordEncoder.matches(password, member.getPassword()))
			return member;
		else
			return null;
	}
	
	
	
}
