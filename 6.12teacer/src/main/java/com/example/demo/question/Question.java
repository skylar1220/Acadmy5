package com.example.demo.question;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.repository.query.parser.Part.IgnoreCaseType;

import com.example.demo.answer.Answer;
import com.example.demo.member.Member;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  // 자동 증가속성
	private Integer id;
	
	@Column(length = 200) // DB용도	
	@NotEmpty(message = "제목은 필수입니다.")
	@Size(max=200)
	private String subject;
	
	@NotEmpty(message = "내용은 필수입니다.")
	@Column(columnDefinition = "TEXT")	
	private String content;
	
	private LocalDateTime createDate;
	
	@OneToMany(mappedBy = "question" , cascade = CascadeType.REMOVE)
	private List<Answer> answerList;
	
	@ManyToOne
	private Member member;
}
