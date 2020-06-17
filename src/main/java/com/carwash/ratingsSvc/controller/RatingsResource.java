package com.carwash.ratingsSvc.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carwash.ratingsSvc.model.Rating;
import com.carwash.ratingsSvc.model.UserRating;

@RestController
@RequestMapping("/ratingsdata")
public class RatingsResource {

    @GetMapping("/schedule/{scheduleId}")
    public Rating getRating(@PathVariable("scheduleId") String scheduleId) {
        return new Rating(scheduleId, 4);
    }

    @GetMapping("/user/{userId}")
    public UserRating getUserRatings(@PathVariable("userId") String userId) {
        UserRating userRating = new UserRating();
        userRating.initData(userId);
        return userRating;

    }

}
