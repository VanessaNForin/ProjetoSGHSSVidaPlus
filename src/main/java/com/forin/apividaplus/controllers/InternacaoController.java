package com.forin.apividaplus.controllers;

import com.forin.apividaplus.dtos.InternacaoInputDTO;
import com.forin.apividaplus.dtos.InternacaoResponseDTO;
import com.forin.apividaplus.services.InternacaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/internacoes")
public class InternacaoController {

    @Autowired
    private InternacaoService internacaoService;

    @PostMapping
    public ResponseEntity<InternacaoResponseDTO> cadastrarInternacao(@Valid @RequestBody InternacaoInputDTO internacao){
        InternacaoResponseDTO novaInternacao = internacaoService.cadastrarInternacao(internacao);

        return ResponseEntity.status(HttpStatus.CREATED).body(novaInternacao);
    }

    @PatchMapping("/{id}/alta")
    public ResponseEntity<Void> darAlta(@PathVariable("id") String idInternacao){
        internacaoService.darAlta(idInternacao);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<InternacaoResponseDTO> consultarInternacao(@PathVariable("id") String idInternacao){
        InternacaoResponseDTO internacao = internacaoService.consultarInternacao(idInternacao);

        return ResponseEntity.status(HttpStatus.OK).body(internacao);
    }

}
