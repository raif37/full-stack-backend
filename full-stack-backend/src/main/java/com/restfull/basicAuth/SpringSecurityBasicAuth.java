package com.restfull.basicAuth;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SpringSecurityBasicAuth extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
		.csrf().disable()  // disable csrf
		.authorizeRequests()
		.antMatchers(HttpMethod.OPTIONS, "/**").permitAll()  // permit all OPTIONS
				.anyRequest().authenticated()   // authenticate any other request
				.and().httpBasic();   // using basic Auth
	}
	

}
