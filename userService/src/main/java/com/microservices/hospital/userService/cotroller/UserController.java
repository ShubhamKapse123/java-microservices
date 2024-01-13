package com.microservices.hospital.userService.cotroller;

import com.microservices.hospital.userService.entities.User;
import com.microservices.hospital.userService.services.UserServices;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServices userServices;



    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User usr){
        User user =userServices.saveUser(usr);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);

    }
    int retryCount=1;
    @GetMapping("/{userId}")
    //@CircuitBreaker(name="ratingUserBreaker",fallbackMethod = "ratingHospitalFallback")
    @Retry(name="ratingUserRetry",fallbackMethod = "ratingHospitalFallback")
    public ResponseEntity<User> getUser(@PathVariable String userId){
        System.out.println("retryCount-- "+retryCount);
        retryCount++;
        User user =userServices.getUser(userId);
        return ResponseEntity.ok(user);
    }

    //creating fall back method for circuitbreaker This For Toler Foulere

    public ResponseEntity<User> ratingHospitalFallback(String userId,Exception ex){
        System.out.println("Fallback is executed because service is down: "+ ex.getMessage());
       User user=User.builder().
               userEmail("user@eamil").
               userAbout("user is fit").
               userName("user").
               userId(userId).
               build();
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUser(){
        List<User> user =userServices.getAllUser();
        return ResponseEntity.ok(user);
    }
}
