package com.example.demo.user;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service	// 어노테이션을 갖고있으면 자동으로 객체화할 수 있게된다 = di = 타입만 맞으면 알아서 넣어준다 = autowired / 추천하는 건 requiredArgus 생성자방식
// 생성자가 있는 빈들은 다 받아올 수 있다. 
@RequiredArgsConstructor
public class MemberService {
	
	private final MemberRepository memberRepository ;	// final을 써줘야 생성자 방식의 객체가 됨
														// requre+final 해주거나 / autowired 해주거나 둘 중 하나 : 더 찾아보기@ 스프링부트 di 생성자주입 vs autowired
	private final PasswordEncoder passwordEncoder;
	
	public void create (Member member) {
		member.setPassword(passwordEncoder.encode(member.getPassword())); 	// 사용자가 입력하는 값은 db에 password 암호화된 형태로 저장되게 됨 -> 관리자가 db를 열어봐도 모르게
		memberRepository.save(member);
	}
	
	
}
