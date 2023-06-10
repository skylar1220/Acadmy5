package com.example.demo.question;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
	
	public Page<Question> getList(int page){
		Pageable pageable =  PageRequest.of(page, 10);
		return qeustionRepository.findAll(pageable);
	}

	public Question getDetail(Integer id) {		
		Optional<Question> q =  qeustionRepository.findById(id);
		if(q.isPresent())
			return q.get();
		else
			throw new DataFoundNotException("Question is not found");
		
	}

	public void create(Question question) {
		question.setCreateDate(LocalDateTime.now());
		qeustionRepository.save(question);
	}

	

}
