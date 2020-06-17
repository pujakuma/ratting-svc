package com.carwash.ratingsSvc.model;

public class Rating {

    private String scheduleId;
    private int rating;

    public Rating(String movieId, int rating) {
        this.scheduleId = movieId;
        this.rating = rating;
    }

   

    public String getScheduleId() {
		return scheduleId;
	}



	public void setScheduleId(String scheduleId) {
		this.scheduleId = scheduleId;
	}



	public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
