package com.carwash.ratingsSvc.response;

public class MessageResponse<T> {
	private String message;
	
private T results;
	
	public MessageResponse(T results) {
		this.results = results;
	}
	
	public T getResults() {
		return this.results;
	}

	public MessageResponse(String message) {
	    this.message = message;
	  }

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
