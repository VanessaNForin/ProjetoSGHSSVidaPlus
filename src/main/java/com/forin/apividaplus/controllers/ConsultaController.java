package com.forin.apividaplus.controllers;

import com.forin.apividaplus.dtos.ConsultaInputDTO;
import com.forin.apividaplus.dtos.ConsultaResponseDTO;
import com.forin.apividaplus.services.ConsultaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    @PostMapping
    public ResponseEntity<ConsultaResponseDTO> marcarConsulta(@Valid @RequestBody ConsultaInputDTO consulta){
        ConsultaResponseDTO consultaMarcada = consultaService.marcarConsulta(consulta);

        return ResponseEntity.status(HttpStatus.CREATED).body(consultaMarcada);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsultaResponseDTO> consultarConsulta(@PathVariable("id") String idConsulta){
        ConsultaResponseDTO consultaConsultada = consultaService.consultarConsulta(idConsulta);

        return ResponseEntity.status(HttpStatus.OK).body(consultaConsultada);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> desmarcarConsulta(@PathVariable("id") String idConsulta){
        consultaService.desmarcarConsulta(idConsulta);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
