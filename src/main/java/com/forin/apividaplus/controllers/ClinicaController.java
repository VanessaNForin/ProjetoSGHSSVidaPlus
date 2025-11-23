package com.forin.apividaplus.controllers;
import com.forin.apividaplus.dtos.ClinicaInputDTO;
import com.forin.apividaplus.dtos.ClinicaResponseDTO;
import com.forin.apividaplus.dtos.ConsultaResponseDTO;
import com.forin.apividaplus.models.infraestrutura.Clinica;
import com.forin.apividaplus.services.ClinicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.forin.apividaplus.mappers.ClinicaMapper.toDTO;

@RestController
@RequestMapping("/clinicas")
public class ClinicaController {

    @Autowired
    private ClinicaService clinicaService;

    @PostMapping
    public ResponseEntity<ClinicaResponseDTO> cadastrarClinica(@RequestBody ClinicaInputDTO clinica){
        Clinica clinicaCriada = clinicaService.cadastrarClinica(clinica);

        ClinicaResponseDTO clinicaDTO = toDTO(clinicaCriada);

        return ResponseEntity.status(HttpStatus.CREATED).body(clinicaDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClinicaResponseDTO> consultarClinica(@PathVariable("id") String idClinica){
        ClinicaResponseDTO clinicaProcurada = clinicaService.consultarClinica(idClinica);

        return ResponseEntity.status(HttpStatus.OK).body(clinicaProcurada);
    }

    @GetMapping("/{id}/consultas")
    public ResponseEntity<List<ConsultaResponseDTO>> consultarConsultasClinica(@PathVariable("id") String idClinica){
        List<ConsultaResponseDTO> listaConsultas = clinicaService.consultarConsultasClinica(idClinica);

        return ResponseEntity.status(HttpStatus.OK).body(listaConsultas);
    }

    @PatchMapping("/{id}/ativo")
    public ResponseEntity<Void> desativarClinica(String idClinica){
        clinicaService.desativarClinica(idClinica);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
