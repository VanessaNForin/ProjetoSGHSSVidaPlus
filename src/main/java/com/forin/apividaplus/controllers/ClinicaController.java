package com.forin.apividaplus.controllers;
import com.forin.apividaplus.dtos.ClinicaInputDTO;
import com.forin.apividaplus.dtos.ClinicaResponseDTO;
import com.forin.apividaplus.dtos.ConsultaResponseDTO;
import com.forin.apividaplus.models.infraestrutura.Clinica;
import com.forin.apividaplus.services.ClinicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clinicas")
public class ClinicaController {

    @Autowired
    private ClinicaService clinicaService;

    @PostMapping
    public Clinica cadastrarClinica(@RequestBody ClinicaInputDTO clinica){
        return clinicaService.cadastrarClinica(clinica);
    }

    @GetMapping("/{id}")
    public ClinicaResponseDTO consultarClinica(@PathVariable("id") String idClinica){
        return clinicaService.consultarClinica(idClinica);
    }

    @GetMapping("/{id}/consultas")
    public List<ConsultaResponseDTO> consultarConsultasClinica(@PathVariable("id") String idClinica){
        return clinicaService.consultarConsultasClinica(idClinica);
    }
}
