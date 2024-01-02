package com.microservices.hospital.userService.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Hospital {
    private String hospitalId;
    private String hospitalName;
    private String hospitalDepartment;
    private String hospitalAddress;
    private String hospitalInfo;
}
