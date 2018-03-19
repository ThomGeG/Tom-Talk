package main.java.controllers;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.handler.annotation.MessageMapping;

import main.java.model.Message;

@Controller
public class MessageController {
	
	@MessageMapping("/chat")
	@SendTo("/topic/chat")
	public Message foo(Principal p, Message m) throws Exception {
		return new Message(m, p);
	}

}
