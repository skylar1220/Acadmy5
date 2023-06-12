package com.example.demo;

import static org.assertj.core.api.Assertions.assertThatList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.question.Question;
import com.example.demo.question.QuestionRepository;

@SpringBootTest
public class ApplicatoinTest2 {
	// DI
	@Autowired
	QuestionRepository qr;
	
	@Test
	public void testSelectAllDataQuestion() {
		List<Question> all =  qr.findAll();
		assertEquals(2, all.size());
		
		Question q =  all.get(0);		
		assertEquals("1.제목입니다", q.getSubject());
	}
	
	@Test
	public void testSelectByData() {
		Optional<Question> oq =  qr.findById(1);
		assertNotNull(oq);
	}
	
	@Test
	public void testSelectBySubject() {
		List<Question> qrlist =  qr.findBySubject("1.제목입니다");
		assertThatList(qrlist);
	}

}
