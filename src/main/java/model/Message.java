package main.java.model;

public class Message {

	private String body;
	
	public Message() {
	}
	
	public Message(String body) {
		setBody(body);
	}
	
	public String getBody() {
		return body;
	}
	
	public void setBody(String body) {
		this.body = body;
	}

}
