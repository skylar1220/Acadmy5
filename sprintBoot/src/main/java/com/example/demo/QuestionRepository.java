package com.example.demo;

import java.util.List;
/*
 * 		And
 * 		Or
 * 		Between				주로 기간 검색
 * 		LessThan		 	작다 <
 * 		GreaterThanEqual	크거나 같다 >=
 * 		Like				select * from Question where subject like '%apple%' 
 * 		In					여러개 중에 하나일 때 select * from Question where id in (10, 20, 30) 
 * 		OrderBy				select * from Question order by id;  기본이 오름차순
 * 
*/
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Integer> {	// <type, pk속성> 와야함
	List <Question> findBySubject(String str);	// 대소문자 구분없이 알아서 Subject와 관련된 애를 반환해주는 것!
	List <Question> findBySubjectAndContent(String subject, String content);
	List <Question> findBySubjectLike(String str);
}
