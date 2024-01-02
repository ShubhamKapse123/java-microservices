package com.microservices.hospital.ratingservice.cotroller;

import com.microservices.hospital.ratingservice.entities.Rating;
import com.microservices.hospital.ratingservice.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping
    public ResponseEntity<Rating> addRating(@RequestBody Rating rate){
       Rating rating= ratingService.addRating(rate);
       return ResponseEntity.status(HttpStatus.CREATED).body(rating);
    }

    @GetMapping
    public ResponseEntity<List<Rating>> getAllRating(){
        List<Rating> listOfRating=ratingService.getAllRating();
        return ResponseEntity.ok(listOfRating);
    }

    @GetMapping("users/{userId}")
    public ResponseEntity<List<Rating>> getRatingByUser(@PathVariable String userId){
        List<Rating> listOfRating=ratingService.getRatingByUserId(userId);
        return ResponseEntity.ok(listOfRating);
    }

    @GetMapping("hospitals/{hospitalId}")
    public ResponseEntity<List<Rating>> getRatingByHotel(@PathVariable String hospitalId){
       List<Rating> listOfRating=ratingService.getRatingByHospitalId(hospitalId);
       return ResponseEntity.ok(listOfRating);
    }

}
