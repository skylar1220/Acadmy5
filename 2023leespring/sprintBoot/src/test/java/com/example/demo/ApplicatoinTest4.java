package com.example.demo;

import java.time.LocalDateTime;
import java.util.Iterator;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.answer.AnswerRepository;
import com.example.demo.question.Question;
import com.example.demo.question.QuestionRepository;

@SpringBootTest
public class ApplicatoinTest4 {
	
	@Autowired
	private QuestionRepository qr;
	
	@Autowired
	private AnswerRepository ar;
	
	@Test
	@Order(1)
	public void testjpa() {
		qr.deleteAll();
		for (int i = 0; i < 100; i++) {
			Question q = new Question();
			q.setSubject("1.제목입니다 " + (i + 1) );
			q.setContent("1.스프링부트에 대해 알고 싶습니다.");
			q.setCreateDate(LocalDateTime.now());
			qr.save(q);
			
		}
		
		
	}
}
