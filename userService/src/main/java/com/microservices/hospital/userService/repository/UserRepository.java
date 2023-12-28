package com.microservices.hospital.userService.repository;

import com.microservices.hospital.userService.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {

}
