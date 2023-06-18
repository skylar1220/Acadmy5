package com.example.demo.answer;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.example.demo.member.Member;
import com.example.demo.question.Question;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AnswerService {

	private final AnswerRepository answerRepository;
	
	public void craete(Question question, String content, Member member) {
		Answer an = new Answer();
		an.setContent(content);
		an.setQuestion(question);
		an.setCreateDate(LocalDateTime.now());
		an.setMember(member);
		answerRepository.save(an);		
	}

}
