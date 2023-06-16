package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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
		
		List<Question> list = qr.findBySubject("2.제목입니다");
		q = lists.get(0);
		assertNotNull(q);
		
		Answer aa = new Answer();
		a.setContent("2. 스프링 부트는 경량 웹프레임웍이며 최근에 많이 사용하고 있습니다.\n 또한 자주사용하는 설정을 미리 셋팅할수 있고 그밖에 많은 장점들이 있습니다.");
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
		List<Answer> arlist = ar.findAll();
		assertTrue(arlist.size()>0);
		Answer ans = arlist.get(0);
		Question q = ans.getQuestion();
		Optional<Question> oq = qr.findById(q.getId());
		assertTrue(oq.isPresent());
		System.out.println("##########"+ q.toString());
	}
}








// arlist 결과
// Answer [id=3, 스프링 부트는 경량 웹프레임웍이며 최근에 많이 사용하고 있습니다., question=com.example.demo.Question@2ac7c683], 
// Answer [id=4, c], Answer [id=5,], Answer [id=6,], Answer [id=7,]]