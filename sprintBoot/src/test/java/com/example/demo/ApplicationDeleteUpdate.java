package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.question.Question;
import com.example.demo.question.QuestionRepository;

@SpringBootTest
public class ApplicationDeleteUpdate {

	@Autowired
	private QuestionRepository qr;
	
	@Test
	@Order(1)
	public void test1() {
		Optional<Question> ooq = qr.findById(1);
		assertFalse(ooq.isEmpty());
		Question q =  ooq.get();
		q.setSubject("짱구는 못말려");
		qr.save(q);
		
		ooq = qr.findById(1);
		assertFalse(ooq.isEmpty());
		q =  ooq.get();
		assertEquals("짱구는 못말려", q.getSubject());		
	}
	
	@Test
	@Order(2)
	public void delete() {
		Optional<Question> op = qr.findById(1);
		assertTrue(op.isPresent());
		qr.delete(op.get());
		
		op = qr.findById(1);
		assertTrue(op.isEmpty());
	}
	
}
