package com.carwash.ratingsSvc.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.carwash.ratingsSvc.model.Ratings;

public interface RatingRepository extends MongoRepository<Ratings, String>{

	
	

	Iterable<Ratings> getRatingsByscheduleId(String scheduleId);

	
	
}
