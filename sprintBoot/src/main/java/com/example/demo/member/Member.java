package com.example.demo.member;

import java.util.List;

import com.example.demo.answer.Answer;
import com.example.demo.question.Question;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  // 자동 증가속성
	private Integer id;
	
	
	private String userName;	
	private String password;
	
	@Column(unique = true)
	private String email;
	
	@OneToMany
	private List<Question> questionList;
	
	@OneToMany
	private List<Answer> answerList; 
	
	
}
