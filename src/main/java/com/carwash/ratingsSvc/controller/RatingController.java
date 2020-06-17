package com.carwash.ratingsSvc.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carwash.ratingsSvc.model.Ratings;
import com.carwash.ratingsSvc.repository.RatingRepository;
import com.carwash.ratingsSvc.response.MessageResponse;
import com.carwash.ratingsSvc.service.RatingService;


@RestController
@RequestMapping("/api")
public class RatingController {
	@Autowired
	  private RatingService ratingService;
	@Autowired
	RatingRepository ratingRepository;
	@GetMapping("/ratings/{scheduleId}")
	public ResponseEntity<MessageResponse<Iterable<Ratings>>> getRatings(@PathVariable("scheduleId") String scheduleId) {
		return ResponseEntity.ok(new MessageResponse<>(ratingService.getRatingsByscheduleId(scheduleId)));
	}

	/*@GetMapping("/ratings/{scheduleId}/{ratingid}")
	public ResponseEntity<MessageResponse<Ratings>> getRating(@PathVariable("scheduleId") String scheduleId,
			@PathVariable("ratingid") String ratingid) {
		return ResponseEntity.ok(new MessageResponse<>(ratingService.getRatingByRatingId(ratingid)));
	}*/

	@PostMapping("/ratings/{scheduleId}")
	public ResponseEntity<MessageResponse<Ratings>> saveRating(@PathVariable("scheduleId") String scheduleId,
			@RequestBody Ratings rating) {
		if (!scheduleId.equals(rating.getScheduleId()))
			throw new RuntimeException("Ids doesn't match");
		
		Ratings savedRating = ratingService.save(rating);
		return ResponseEntity
				.created(URI.create("/" + savedRating.getScheduleId() + "/ratings/" + savedRating.getRatingId()))
				.body(new MessageResponse<>(savedRating));
	}

	@PutMapping("/ratings/{scheduleId}/{ratingid}")
	public ResponseEntity<?> updateRating(@PathVariable("scheduleId") String scheduleId,
			@PathVariable("ratingid") String ratingId, @RequestBody Ratings rating) {
		ratingService.update(rating);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/ratings/{scheduleId}/{ratingid}")
	public ResponseEntity<MessageResponse<Long>> deleteRating(@PathVariable("scheduleId") String scheduleId,
			@PathVariable("ratingid") String ratingid) {
		ratingRepository.deleteById(ratingid);
		return ResponseEntity.ok(new MessageResponse<>(ratingid));
	}

}
