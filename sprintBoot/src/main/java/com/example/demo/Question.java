package com.example.demo;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Question {
	// jpa: 데이터베이스를 쉽게 하기 위해서 객체
	// 그래서 이건 테이블 생성하는 것
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 		// @GeneratedValue = 자동 증가 속성 (id 1,2,3...) / strategy 고유번호 생성 옵션 / GenerationType.IDENTITY 각각 만들겠다.
	private Integer id;		// 퀘스쳔이라는 테이블의 pk인 아이디가 되는 것
	
	@Column(length = 200)
	private String subject ; 
	
	@Column(columnDefinition = "TEXT")
	private String content ; 
	
	private LocalDateTime createDate;
	
	@OneToMany(mappedBy = "question" , cascade = CascadeType.REMOVE)	// 연속적으로 영향을 미치는 것은, 삭제한다. 부모가 변경이 되면 어떻게할거냥? 삭제
	private List<Answer> answerList ;
	
	
	
}
