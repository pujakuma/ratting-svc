package com.carwash.ratingsSvc.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="ratings")

public class Ratings {
@Id	
private String ratingId;
	
	private double rating;
	
	
	private String scheduleId;
	
	
	private String userId;


	public Ratings() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Ratings(String ratingId, double rating, String scheduleId, String userId) {
		super();
		this.ratingId = ratingId;
		this.rating = rating;
		this.scheduleId = scheduleId;
		this.userId = userId;
	}


	public String getRatingId() {
		return ratingId;
	}


	public void setRatingId(String ratingId) {
		this.ratingId = ratingId;
	}


	public double getRating() {
		return rating;
	}


	public void setRating(double rating) {
		this.rating = rating;
	}


	public String getScheduleId() {
		return scheduleId;
	}


	public void setScheduleId(String scheduleId) {
		this.scheduleId = scheduleId;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	@Override
	public String toString() {
		return "Ratings [ratingId=" + ratingId + ", rating=" + rating + ", scheduleId=" + scheduleId + ", userId="
				+ userId + "]";
	}
	

}
