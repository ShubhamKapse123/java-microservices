package com.microservices.hospital.userService.services;

import com.microservices.hospital.userService.entities.User;

import java.util.List;

public interface UserServices {

    User saveUser(User user);
    List<User> getAllUser();
    User getUser(String userId);

    //user update
    //user delete
}
