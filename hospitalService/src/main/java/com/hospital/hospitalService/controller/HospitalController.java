package com.hospital.hospitalService.controller;

import com.hospital.hospitalService.entites.Hospital;
import com.hospital.hospitalService.service.HospitalServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/hospital")
public class HospitalController {

@Autowired
private HospitalServices hospitalServices;

    @GetMapping
    public ResponseEntity<List<Hospital>> getAllHospital(){
        List<Hospital> hospitalList=hospitalServices.getAllHospital();
        return  ResponseEntity.ok(hospitalList);
    }

    @GetMapping("/{hospitalId}")
    public ResponseEntity<Hospital> getHospital(@PathVariable String hospitalId){
        Hospital hospital= hospitalServices.getHospital(hospitalId);
        return ResponseEntity.ok(hospital);
    }

    @PostMapping
    public ResponseEntity<Hospital> addHospital(@RequestBody Hospital hospital){
        Hospital hos= hospitalServices.addHospital(hospital);
        return ResponseEntity.status(HttpStatus.CREATED).body(hos);
    }
}
