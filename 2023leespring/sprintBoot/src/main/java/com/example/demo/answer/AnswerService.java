package com.example.demo.answer;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.example.demo.question.Question;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AnswerService {

	private final AnswerRepository answerRepository;
	public void create(Question question, String content) {
		Answer an = new Answer();
		an.setContent(content);
		an.setQuestion(question);
		an.setCreateDate(LocalDateTime.now());
		answerRepository.save(an);
	}

}
