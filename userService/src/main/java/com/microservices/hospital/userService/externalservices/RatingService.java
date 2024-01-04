package com.microservices.hospital.userService.externalservices;

import com.microservices.hospital.userService.entities.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(name="RATING-SERVICE")
public interface RatingService {

    @GetMapping("/rating/users/{userId}")
    Rating[] getRatingList(@PathVariable String userId);

    @PostMapping("/rating")
    Rating createRating(Rating values);

}
