package main.java.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.handler.annotation.MessageMapping;

import main.java.model.Message;

@Controller
public class MessageController {
	
	@MessageMapping("/chat")
	@SendTo("/ws/chat")
	public Message foo(Message m) throws Exception {
		return m;
	}

}
