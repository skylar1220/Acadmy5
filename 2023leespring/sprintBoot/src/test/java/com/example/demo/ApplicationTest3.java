package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.question.Question;
import com.example.demo.question.QuestionRepository;

@SpringBootTest
public class ApplicationTest3 {

	@Autowired
	private QuestionRepository qr;
	
	@Test
	public void test1() {
		List<Question> lists 
			= qr.findBySubjectAndContent("1.제목입니다", "1.스프링부트에 대해 알고 싶습니다.");
		assertNotNull(lists);
	}
	
	@Test
	public void test2() {
		List<Question> lists = qr.findBySubjectLike("%제목%");
		System.out.println("##################### "+ lists.size() );
		assertNotNull(lists);
	}
	
	
	
}
