package com.example.demo.question;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

// 의존관계(Dependency Injection) 주입을 위해  생성자 방식
@RequiredArgsConstructor
@Service
public class QuestionService {
	
	private final QuestionRepository qeustionRepository;
	
	public List<Question> getList(){
		return qeustionRepository.findAll();
	}

	public Question getDetail(Integer id) {		
		Optional<Question> q =  qeustionRepository.findById(id);
		if(q.isPresent())
			return q.get();
		else
			throw new DataFoundNotException("Question is not found");
		
	}

	

}
