package com.hospital.hospitalService.service;

import com.hospital.hospitalService.entites.Hospital;
import com.hospital.hospitalService.exception.ResourceNotFoundException;
import com.hospital.hospitalService.repository.HospitalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HospitalServicesImpl implements HospitalServices {

    @Autowired
    private HospitalRepo hospitalRepo;


    @Override
    public Hospital addHospital(Hospital hospital) {
        String uuid = UUID.randomUUID().toString();
        hospital.setHospitalId(uuid);
        return hospitalRepo.save(hospital);
    }

    @Override
    public Hospital getHospital(String hospitalId) {
        return hospitalRepo.findById(hospitalId).orElseThrow(()-> new ResourceNotFoundException("Hospital with give Id not found "+hospitalId));
    }

    @Override
    public List<Hospital> getAllHospital() {
        return hospitalRepo.findAll();
    }
}
