package com.forin.apividaplus.controllers;

import com.forin.apividaplus.dtos.ExameInputDTO;
import com.forin.apividaplus.dtos.ExameResponseDTO;
import com.forin.apividaplus.models.atendimento.Exame;
import com.forin.apividaplus.services.ExameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.forin.apividaplus.mappers.ExameMapper.toDTO;

@RestController
@RequestMapping("/exames")
public class ExameController {

    @Autowired
    private ExameService exameService;

    @PostMapping
    public ResponseEntity<ExameResponseDTO> marcarExame(@RequestBody ExameInputDTO exame){
        Exame exameAgendado = exameService.marcarExame(exame);

        ExameResponseDTO exameDTO = toDTO(exameAgendado);

        return ResponseEntity.status(HttpStatus.CREATED).body(exameDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExameResponseDTO> consultarExame(@PathVariable("id") String idExame){
        ExameResponseDTO exameConsulta = exameService.consultarExame(idExame);

        return ResponseEntity.status(HttpStatus.OK).body(exameConsulta);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> desmarcarExame(@PathVariable("id") String idExame){
        exameService.desmarcarExame(idExame);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
