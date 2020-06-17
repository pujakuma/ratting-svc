package com.carwash.ratingsSvc.service;

import com.carwash.ratingsSvc.model.Ratings;

public interface RatingService {

	Ratings save(Ratings entity);

	

	Iterable<Ratings> getRatingsByscheduleId(String scheduleId);



	void update(Ratings rating);

	


	//Object get(Long ratingid);



	
	
	

}
