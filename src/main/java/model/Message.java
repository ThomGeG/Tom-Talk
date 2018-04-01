package main.java.model;

import com.fasterxml.jackson.annotation.JsonProperty;

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
	private User poster;

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
		setPoster(null);
		setDateTime();
	}
	
	public Message(String body) {
		setID(-1);
		setBody(body);
		setMessageType(MessageType.CHAT);
		setPoster(null);
		setDateTime();
	}
	
	public Message(Message m, User u) {
		setID(m.id);
		setBody(m.body);
		setMessageType(m.type);
		setPoster(u);
		setDateTime(m.datetime);	
	}

	private void setID(long id) {
		this.id = id;
	}
	
	private void setBody(String body) {
		this.body = body;
	}
	
	private void setPoster(User poster) {
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
	
	@JsonProperty("id")
	public long getID() {
		return id;
	}
	
	@JsonProperty("body")
	public String getBody() {
		return body;
	}
	
	@JsonProperty("poster")
	public User getPoster() {
		return poster;
	}
	
	@JsonProperty("datetime")
	public long getDateTime() {
		return datetime;
	}
	
	@JsonProperty("message_type")
	public MessageType getMessageType() {
		return type;
	}
	


}
