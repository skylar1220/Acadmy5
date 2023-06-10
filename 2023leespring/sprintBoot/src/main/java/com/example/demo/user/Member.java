package com.example.demo.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity // 얘가 있으면 db가 됨
public class Member {	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  // 자동 증가속성
	private Integer id;
	
	private String userName;
	
	private String password;
	
	@Column(unique = true )
	private String email;
}
