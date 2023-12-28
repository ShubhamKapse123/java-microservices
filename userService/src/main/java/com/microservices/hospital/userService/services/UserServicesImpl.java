package com.microservices.hospital.userService.services;

import com.microservices.hospital.userService.entities.User;
import com.microservices.hospital.userService.exception.ResourceNotFoundException;
import com.microservices.hospital.userService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServicesImpl implements UserServices{
    @Autowired
    private UserRepository userRepository;

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
        return userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User with give Id not found "+userId));

    }
}
