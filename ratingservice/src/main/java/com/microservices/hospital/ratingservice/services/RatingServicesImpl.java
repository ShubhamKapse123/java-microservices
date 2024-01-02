package com.microservices.hospital.ratingservice.services;


import com.microservices.hospital.ratingservice.entities.Rating;
import com.microservices.hospital.ratingservice.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RatingServicesImpl implements RatingService{
    @Autowired
    private RatingRepository ratingRepository;


    @Override
    public Rating addRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getAllRating() {
        return ratingRepository.findAll();
    }

    @Override
    public List<Rating> getRatingByUserId(String userId) {
        return ratingRepository.findByUserId(userId);
    }

    @Override
    public List<Rating> getRatingByHospitalId(String hospitalId) {
        return ratingRepository.findByHospitalId(hospitalId);
    }
}
