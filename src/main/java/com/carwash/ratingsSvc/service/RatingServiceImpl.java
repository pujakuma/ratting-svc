package com.carwash.ratingsSvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carwash.ratingsSvc.model.Ratings;
import com.carwash.ratingsSvc.repository.RatingRepository;

@Service
public class RatingServiceImpl implements RatingService {
	
	@Autowired
	RatingRepository ratingRepository;
	
	@Override
	public Iterable<Ratings> getRatingsByscheduleId(final String scheduleId) {
		return this.ratingRepository.getRatingsByscheduleId(scheduleId);
	}

	@Override
	public Ratings save(Ratings rating) {
		/*if (!scheduleRepository.exists(rating.getScheduleId()) || !userRepository.exists(rating.getUserId())) {
			throw new ResourceNotFoundException("Either scheduleId or userId doesn't exists: " + rating);
		}*/
		return ratingRepository.save(rating);
	}

	@Override
	public void update(Ratings rating) {
		// TODO Auto-generated method stub
		
	}

	/*@Override
	public Object get(Long ratingid) {
		// TODO Auto-generated method stub
		return null;
	}*/

}
