package com.microservices.hospital.userService.cotroller;

import com.microservices.hospital.userService.entities.User;
import com.microservices.hospital.userService.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUser(@PathVariable String userId){
        User user =userServices.getUser(userId);
        return ResponseEntity.ok(user);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUser(){
        List<User> user =userServices.getAllUser();
        return ResponseEntity.ok(user);
    }
}
