package com.example.demo.user;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberForm {
	@Size(min = 3, max = 30)
	@NotEmpty(message = "유저명은 필수입니다.")
	private String userName;
	
	@NotEmpty(message = "패스워드는 필수입니다.")
	private String password;
	
	@NotEmpty(message = "패스워드 확인은 필수입니다.")
	private String confirmPassword;
	
	@NotEmpty(message = "이메일은 필수입니다.")
	@Email
	private String email;
	
	
}
