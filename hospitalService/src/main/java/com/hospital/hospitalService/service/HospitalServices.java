package com.hospital.hospitalService.service;

import com.hospital.hospitalService.entites.Hospital;

import java.util.List;

public interface HospitalServices {

Hospital addHospital(Hospital hospital);

Hospital getHospital(String hospitalId);

 List<Hospital> getAllHospital();

}
