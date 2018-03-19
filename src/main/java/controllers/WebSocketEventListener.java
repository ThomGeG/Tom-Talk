package main.java.controllers;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import main.java.model.Message;

import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.context.event.EventListener;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class WebSocketEventListener {

	private static final Logger logger = LoggerFactory.getLogger(WebSocketEventListener.class);
	
	@Autowired
	private SimpMessageSendingOperations messagingTemplate;
	
	@EventListener
	public void handleWebSocketConnect(SessionConnectedEvent e) {
		logger.info("New connection!");
	}
	
	@EventListener
	public void handleWebSocketDisconnect(SessionDisconnectEvent e) {
		
		StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(e.getMessage());
		Map<String, Object> userProperties = headerAccessor.getSessionAttributes();
		
		//userProperties.get("name");
		logger.info("User disconnected!");
		
		Message m = new Message();
		
	}
	
}
