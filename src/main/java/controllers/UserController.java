package main.java.controllers;

import java.security.Principal;

import java.util.Map;
import java.util.LinkedHashMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@RequestMapping("/user")
	public Principal user(Principal p) {
		
		Map<String, String> m = new LinkedHashMap<>();
		
		m.put("name", p.getName());
		
		return p;
	}
	
}
