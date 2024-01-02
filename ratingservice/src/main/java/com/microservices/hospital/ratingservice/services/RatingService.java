package com.microservices.hospital.ratingservice.services;


import com.microservices.hospital.ratingservice.entities.Rating;
import org.springframework.stereotype.Service;

import java.util.List;
public interface RatingService {
    Rating addRating(Rating rating);

    List<Rating> getAllRating();

    List<Rating> getRatingByUserId(String userId);

    List<Rating> getRatingByHospitalId(String hospitalId);


}
