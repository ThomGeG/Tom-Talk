package main.java.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.messaging.handler.annotation.MessageMapping;

import main.java.model.User;
import main.java.model.Message;

@Controller
public class MessageController {
	
	@MessageMapping("/chat")
	@SendTo("/topic/chat")
	public Message foo(OAuth2Authentication user, Message m) throws Exception {
		return new Message(m, new User(user));
	}

}
