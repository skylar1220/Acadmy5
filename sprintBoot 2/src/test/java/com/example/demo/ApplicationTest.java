package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.answer.Answer;
import com.example.demo.answer.AnswerRepository;
import com.example.demo.question.Question;
import com.example.demo.question.QuestionRepository;

@SpringBootTest
public class ApplicationTest {
	@Autowired
	private QuestionRepository qr;
	
	@Autowired
	private AnswerRepository ar;
	
	
	@Test
	@Order(1)
	public void testjpa() {
		qr.deleteAll();
		
		
		Question q = new Question();
		q.setSubject("1.제목입니다");
		q.setContent("1.스프링부트에 대해 알고 싶습니다.");
		q.setCreateDate(LocalDateTime.now());
		qr.save(q);
		
		Question q2 = new Question();
		q2.setSubject("2.제목입니다");
		q2.setContent("2.스프링부트에 대해 알고 싶습니다.");
		q2.setCreateDate(LocalDateTime.now());
		qr.save(q2);
		
		// 답변 달기
		List<Question> lists = qr.findBySubject("1.제목입니다");
		q = lists.get(0);
		assertNotNull(q);
		
		Answer a = new Answer();
		a.setContent("스프링 부트는 경량 웹프레임웍이며 최근에 많이 사용하고 있습니다.\n 또한 자주사용하는 설정을 미리 셋팅할수 있고 그밖에 많은 장점들이 있습니다.");
		a.setCreateDate(LocalDateTime.now());
		a.setQuestion(q);
		ar.save(a);
	}
	
	
	
	/**
	 * 답변에 연결된 질문 찾기
	 */
	@Test
	@Order(2)
	@Transactional
	public void testjpa2() {
		// 답변 찾기
		// 전부찾아서 개수가 1개이상인지 체크하고. 그중에 가장 첫번째 답변을 가져온다
		List<Answer> arlists =  ar.findAll();
		assertTrue(arlists.size() > 0);
		Answer ans =  arlists.get(0);
		ans.getContent();
		// 조회를 하고나면 DB세션이 끊어진다 필요한 시점에 데이터를 가져오는 방식을 Lazy방식
		
		
		
	}
}
