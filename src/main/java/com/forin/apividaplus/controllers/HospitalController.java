package com.forin.apividaplus.controllers;

import com.forin.apividaplus.dtos.HospitalInputDTO;
import com.forin.apividaplus.dtos.LeitoResponseDTO;
import com.forin.apividaplus.models.infraestrutura.Hospital;
import com.forin.apividaplus.services.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hospitais")
public class HospitalController {

    @Autowired
    private HospitalService hospitalService;

    @PostMapping
    public Hospital cadastraHospital(@RequestBody HospitalInputDTO hospital){
        return hospitalService.cadastrarHospital(hospital);
    }

    @GetMapping("/{id}")
    public List<LeitoResponseDTO> listarTodosOsLeitos(@PathVariable("id") String idHospital){
        return hospitalService.listarTodosOsLeitos(idHospital);
    }

//    @DeleteMapping("/{id}")
//    public void deletarHospital(@PathVariable("id") String idHospital){
//        hospitalService.deletarHospital(idHospital);
//    }
}
