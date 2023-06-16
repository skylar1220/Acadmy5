package com.example.demo;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;

import com.example.demo.answer.AnswerRepository;
import com.example.demo.question.Question;
import com.example.demo.question.QuestionRepository;

@SpringBootTest
public class ApplicationTest4 {
	@Autowired
	private QuestionRepository qr;
	
	@Autowired 
	private AnswerRepository ar;
	
	@Test
	@Order(1)
	public void testjpa() {
		qr.deleteAll();
		for(int i = 0 ; i < 100 ; i ++) {
			Question q =  new Question();
			q.setSubject("1.제목" + (i+1));
			q.setContent("1.내용");
			q.setCreateDate(LocalDateTime.now());
			qr.save(q);
		}
	}

}
