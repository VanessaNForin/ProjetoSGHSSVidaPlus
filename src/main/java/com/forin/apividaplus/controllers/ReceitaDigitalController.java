package com.forin.apividaplus.controllers;

import com.forin.apividaplus.dtos.ReceitaDigitalInputDTO;
import com.forin.apividaplus.dtos.ReceitaDigitalResponseDTO;
import com.forin.apividaplus.models.atendimento.ReceitaDigital;
import com.forin.apividaplus.services.ReceitaDigitalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/receitas-digitais")
public class ReceitaDigitalController {

    @Autowired
    private ReceitaDigitalService receitaDigitalService;

    @PostMapping
    public ResponseEntity<ReceitaDigitalResponseDTO> emitirReceitaDigital(@Valid @RequestBody ReceitaDigitalInputDTO receita){
        ReceitaDigitalResponseDTO novaReceita = receitaDigitalService.emitirReceitaDigital(receita);

        return ResponseEntity.status(HttpStatus.CREATED).body(novaReceita);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReceitaDigitalResponseDTO> consultarReceitaDigital(String idReceita){
        ReceitaDigitalResponseDTO receita = receitaDigitalService.consultarReceita(idReceita);

        return ResponseEntity.status(HttpStatus.OK).body(receita);
    }
}
