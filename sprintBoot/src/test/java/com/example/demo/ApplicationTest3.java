package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ApplicationTest3 {
	@Autowired
	QuestionRepository qr ; // 객체가 프레임워크에 알아서 넣어준다.
	
//	@Test
	public void test1() {
		List <Question> lists = qr.findBySubjectAndContent("1. 제목입니다.", "1. 스프링부트에 대해 알고 싶습니다.");
		assertNotNull(lists);
	}
	
	@Test
	public void test2() {
		List <Question> lists = qr.findBySubjectLike("%제목%");
		System.out.println("#############"+lists.size());
		assertNotNull(lists);
	}
}
