package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
// CSRF (Cross Site Request Forgery)
// 	CSRF 토큰값을 발행 실제페이지에서 발행된 정보인지 검증하는 기술
	@SuppressWarnings("removal")
	@Bean
	SecurityFilterChain filterChanin(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests((authorizeHttpRequests) ->
				{
					try {
						authorizeHttpRequests
						.requestMatchers("/**").permitAll()
						.and()
						.csrf()
						.ignoringRequestMatchers(new AntPathRequestMatcher("/h2-console/**"))
						.and()
						.headers()
						.addHeaderWriter(
								new XFrameOptionsHeaderWriter(
										XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN))
						;
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}				
			);		
			
		return http.build();
		
	}
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
}
