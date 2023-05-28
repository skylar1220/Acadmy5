package com.example.demo;

import static org.assertj.core.api.Assertions.assertThatList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest // 이게 꼭 있어야함
public class ApplicationTest2 {
	
	//DI : 알아서 넣어주겠다
	
	@Autowired
	QuestionRepository qr;
	
	
	@Test
	public void testSelectAllQuestion() {	
		List<Question> all = qr.findAll();
		assertEquals(2, all.size()); 
		
		Question q =  all.get(0);
		assertEquals("1. 제목입니다.", q.getSubject()); 
	}
	
	@Test
	public void testSelectByData() {	
		Optional<Question> oq = qr.findById(5);
		assertNotNull(oq);
		
	}
	
	@Test
	public void testSelectBysubject() {
		List<Question> qrlist =  qr.findBySubject("1. 제목입니다.");
		assertThatList(qrlist);
	}
	
	
	
	
}
