package com.microservices.hospital.userService.services;

import com.microservices.hospital.userService.entities.Hospital;
import com.microservices.hospital.userService.entities.Rating;
import com.microservices.hospital.userService.entities.User;
import com.microservices.hospital.userService.exception.ResourceNotFoundException;
import com.microservices.hospital.userService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServicesImpl implements UserServices{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public User saveUser(User user) {
        String uuid= UUID.randomUUID().toString();
        user.setUserId(uuid);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {
            User user = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User with give Id not found "+userId));
            Rating[] ratingarr= restTemplate.getForObject("http://RATING-SERVICE/rating/users/"+user.getUserId(), Rating[].class);
            List<Rating> ratingList=Arrays.stream(ratingarr).toList();
            user.setRating(ratingList);

            ratingList.stream().map(rating -> {
            Hospital hospital=restTemplate.getForObject("http://HOSPITAL-SERVICE/hospital/"+rating.getHospitalId(), Hospital.class);
            rating.setHospital(hospital);
            return rating;
            }).collect(Collectors.toList());

            return user;
    }
}
