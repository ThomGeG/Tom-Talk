package main.java.controllers;

import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.java.model.User;

@RestController
public class UserController {

	@RequestMapping("/user")
	public User user(OAuth2Authentication authentication) {
		return new User(authentication);
	}
	
}
