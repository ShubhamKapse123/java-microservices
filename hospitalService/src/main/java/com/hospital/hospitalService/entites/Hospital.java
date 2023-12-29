package com.hospital.hospitalService.entites;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "hospital_service")
public class Hospital {
    @Id
    @Column(name = "hospital_Id")
    private String hospitalId;
    @Column(name = "hospital_Name")
    private String hospitalName;
    @Column(name = "hospital_Department")
    private String hospitalDepartment;
    @Column(name = "hospital_Address")
    private String hospitalAddress;
    @Column(name = "hospital_Info")
    private String hospitalInfo;
}
