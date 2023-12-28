package com.hospital.hospitalService.repository;

import com.hospital.hospitalService.entites.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepo extends JpaRepository<Hospital,String> {
}
