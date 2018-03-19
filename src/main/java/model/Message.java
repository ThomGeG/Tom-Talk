package main.java.model;

import java.security.Principal;

public class Message {
	
	/** Content/Body of the message. */
	private String body;
	
	//Meta-data
	
	/** Unique identifier for the message. */
	private long id = 1;
	/** The type of message being sent. */
	private MessageType type;
	/** Date/Time of message creation (Millis). */
	private long datetime;
	/** Name of message creator. */
	private String poster;

	/** Enum representing the type of message being sent. */
	public enum MessageType {
		CHAT, //Somebody is talking.
		JOIN, //Somebody has joined.
		LEAVE //Somebody has left.
	}
	
	public Message() {
		setID(-1);
		setBody("");
		setMessageType(MessageType.CHAT);
		setPoster("");
		setDateTime();
	}
	
	public Message(String body) {
		setID(-1);
		setBody(body);
		setMessageType(MessageType.CHAT);
		setPoster("");
		setDateTime();
	}
	
	public Message(Message m, Principal p) {
		setID(m.id);
		setBody(m.body);
		setMessageType(m.type);
		setPoster(p.getName());
		setDateTime(m.datetime);	
	}

	private void setID(long id) {
		this.id = id;
	}
	
	private void setBody(String body) {
		this.body = body;
	}
	
	private void setPoster(String poster) {
		this.poster = poster;
	}
	
	private void setDateTime() {
		this.datetime = System.currentTimeMillis();
	}
	
	private void setDateTime(long datetime) {
		this.datetime = datetime;
	}
	
	private void setMessageType(MessageType type) {
		this.type = type;
	}
	
	public long getID() {
		return id;
	}
	
	public String getBody() {
		return body;
	}
	
	public String getPoster() {
		return poster;
	}
	
	public long getDateTime() {
		return datetime;
	}
	
	public MessageType getMessageType() {
		return type;
	}
	


}
