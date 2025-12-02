package com.forin.apividaplus.controllers;

import com.forin.apividaplus.dtos.LaboratorioInputDTO;
import com.forin.apividaplus.dtos.LaboratorioResponseDTO;
import com.forin.apividaplus.models.infraestrutura.Laboratorio;
import com.forin.apividaplus.services.LaboratorioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/laboratorios")
public class LaboratorioController {

    @Autowired
    private LaboratorioService laboratorioService;

    @PostMapping
    public ResponseEntity<LaboratorioResponseDTO> cadastrarLaboratorio(@Valid @RequestBody LaboratorioInputDTO laboratorio){
        LaboratorioResponseDTO novoLaboratorio = laboratorioService.cadastrarLaboratorio(laboratorio);

        return ResponseEntity.status(HttpStatus.CREATED).body(novoLaboratorio);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LaboratorioResponseDTO> consultarLaboratorio(String idLaboratorio){
        LaboratorioResponseDTO laboratorio = laboratorioService.consultarLaboratorio(idLaboratorio);

        return ResponseEntity.status(HttpStatus.OK).body(laboratorio);
    }

    @PatchMapping("/{id}/desativar")
    public ResponseEntity<Void> desativarLaboratorio(String idLaboratorio){
        laboratorioService.desativarLaboratorio(idLaboratorio);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
