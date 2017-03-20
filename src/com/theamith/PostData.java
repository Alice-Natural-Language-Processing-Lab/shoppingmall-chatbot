package com.theamith;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PostData {
	String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("{\"message\":\"");
		builder.append(message);
		builder.append("\"}");
		return builder.toString();
	}
	
}
