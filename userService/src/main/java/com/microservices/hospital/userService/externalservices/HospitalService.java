package com.microservices.hospital.userService.externalservices;

import com.microservices.hospital.userService.entities.Hospital;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="HOSPITAL-SERVICE")
public interface HospitalService {

    @GetMapping("/hospital/{hospitalId}")
    Hospital getHospital(@PathVariable("hospitalId") String hospitalId);

}
