package com.forin.apividaplus.controllers;

import com.forin.apividaplus.dtos.LeitoInputDTO;
import com.forin.apividaplus.dtos.LeitoResponseDTO;
import com.forin.apividaplus.models.infraestrutura.Leito;
import com.forin.apividaplus.services.LeitoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/leitos")
public class LeitoController {

    @Autowired
    private LeitoService leitoService;

    @PostMapping
    public ResponseEntity<LeitoResponseDTO> cadastrarLeito(@RequestBody LeitoInputDTO leito){
        LeitoResponseDTO novoLeito = leitoService.cadastrarLeito(leito);

        return ResponseEntity.status(HttpStatus.CREATED).body(novoLeito);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LeitoResponseDTO> consultarLeito(@PathVariable("id") String idLeito){
        LeitoResponseDTO leito = leitoService.consultarLeito(idLeito);

        return ResponseEntity.status(HttpStatus.OK).body(leito);
    }

    @PatchMapping("/{id}/desativar")
    public ResponseEntity<Void> desativarLeito(String idLeito){
        leitoService.desativarLeito(idLeito);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
