package main.java.model;

import java.util.LinkedHashMap;

import org.springframework.security.oauth2.provider.OAuth2Authentication;

public class User {
	
	public final String name;
	
	public User(OAuth2Authentication auth) {
		
		@SuppressWarnings("unchecked")
		LinkedHashMap<String, Object> user = (LinkedHashMap<String, Object>) auth.getUserAuthentication().getDetails();
		
		this.name = (String) user.get("name");
				
	}

}
