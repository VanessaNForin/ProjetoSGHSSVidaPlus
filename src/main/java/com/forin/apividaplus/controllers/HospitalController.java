package com.forin.apividaplus.controllers;

import com.forin.apividaplus.dtos.HospitalDTO;
import com.forin.apividaplus.models.infraestrutura.Hospital;
import com.forin.apividaplus.services.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hospitais")
public class HospitalController {

    @Autowired
    private HospitalService hospitalService;

    @PostMapping
    public Hospital cadastraHospital(@RequestBody HospitalDTO hospital){
        return hospitalService.cadastrarHospital(hospital);
    }


}
