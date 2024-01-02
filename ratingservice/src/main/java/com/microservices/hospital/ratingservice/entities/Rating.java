package com.microservices.hospital.ratingservice.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document("rating_service")
public class Rating {
    @Id
    private String ratingId;
    private String userId;
    private String hospitalId;
    private int rating;
    private String feedback;
}
