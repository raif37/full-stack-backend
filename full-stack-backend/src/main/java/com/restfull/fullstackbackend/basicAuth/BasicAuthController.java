package com.restfull.fullstackbackend.basicAuth;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins="http://localhost:4200")
@RestController
public class BasicAuthController {
	
	
	@RequestMapping("/basicAuth")
	public AuthenticationBean helloWorldBean() {
//		throw new RuntimeException("Some Error has Happened! Contact Support at ***_***");
		return new AuthenticationBean("You are Authenticated");
	}


}
