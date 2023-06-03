package com.example.demo.question;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 *		And					
 *		Or					
 *		Between				주로 기간검색
 *		LessThan			작다  <
 *		GreaterThanEqual    크거나같다  >=
 *		Like				select * from Question where subject like '%apple%'
 *		In					여러개 중에 하나일대 select * from Question where id in (10,20,30) 
 *		OrderBy				select * from Queston order by id; 기본이 오름차순
 */


public interface QuestionRepository extends JpaRepository<Question, Integer> {
	List<Question> findBySubject(String str);
	List<Question> findBySubjectAndContent(String subject, String content);
	List<Question> findBySubjectLike(String str);
}