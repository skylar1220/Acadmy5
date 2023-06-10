package com.example.demo.question;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.repository.query.parser.Part.IgnoreCaseType;

import com.example.demo.answer.Answer;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  // 자동 증가속성
	private Integer id;
	
	@NotEmpty(message = "유저명은 필수입니다.")
	@Column(length = 200) // db 용도
	private String subject;
	
	@NotEmpty(message = "유저명은 필수입니다.")
	@Column(columnDefinition = "TEXT")
	private String content;
	
	private LocalDateTime createDate;
	
	@OneToMany(mappedBy = "question" , cascade = CascadeType.REMOVE)
	private List<Answer> answerList;
}
