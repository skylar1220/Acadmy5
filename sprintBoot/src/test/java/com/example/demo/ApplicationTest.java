package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ApplicationTest {
	@Autowired
	private QuestionRepository qr;
	
	@Autowired
	private AnswerRepository ar ; 
	
	
	@Test
	@Order(1)
	public void testjpa() {
		qr.deleteAll();
		
		Question q = new Question();
		q.setSubject("1. 제목입니다.");
		q.setContent("1. 스프링부트에 대해 알고 싶습니다.");
		q.setCreateDate(LocalDateTime.now());
		qr.save(q);
		
		Question q2 = new Question();
		q2.setSubject("2. 제목입니다.");
		q2.setContent("2. 스프링부트에 대해 알고 싶습니다.");
		q2.setCreateDate(LocalDateTime.now());
		qr.save(q2);
		
		// 답변 달기
		List<Question> lists = qr.findBySubject("1. 제목입니다.");
		q =  lists.get(0);
		assertNotNull(q);
		
		Answer a = new Answer() ;
		a.setContent("스프링 부트는 경량 웹프레임웍이며 최근에 많이 사용하고 있습니다. \n 또한 자주 사용하는 설정을 미리 세팅할 수 있고 그 밖에 많은 장점들이 있습니다.");
		a.setCreateDate(LocalDateTime.now());
		a.setQuestion(q);
		ar.save(a);
	}
	
	/* 
	 * 답변에 연결된 질문 찾기
	 * select 
			q.subject, q.content, q.create_date, a.content, a.create_date
		form question q
		left join answer a
		on q.id = a.question_id
;
	 * */
	
	@Test
	@Order(2)
	public void testjpa2() {
		Question q = new Question();
		List<Question> qlists = qr.findBySubject("1. 제목입니다.");
		q = qlists.get(0);
		assertNotNull(q);
		
		Optional<Answer> alists = ar.findById(q.getId());
		
		
		
	}
	
}
