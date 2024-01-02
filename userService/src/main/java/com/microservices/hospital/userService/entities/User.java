package com.microservices.hospital.userService.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.*;

import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="hospital_users")
public class User {
    @Id
    private String userId;
    private String userName;
    private String userType;
    private String userEmail;
    private String userAbout;
    @Transient
    private List<Rating> rating;
}
