package com.forin.apividaplus.controllers;

import com.forin.apividaplus.dtos.TecnicoInputDTO;
import com.forin.apividaplus.dtos.TecnicoResponseDTO;
import com.forin.apividaplus.models.pessoas.Tecnico;
import com.forin.apividaplus.services.TecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tecnicos")
public class TecnicoController {

    @Autowired
    private TecnicoService tecnicoService;

    @PostMapping
    public ResponseEntity<TecnicoResponseDTO> cadastrarTecnico(@RequestBody TecnicoInputDTO tecnico){
        TecnicoResponseDTO novoTecnico = tecnicoService.cadastrarTecnico(tecnico);

        return ResponseEntity.status(HttpStatus.CREATED).body(novoTecnico);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TecnicoResponseDTO> consultarTecnico(@PathVariable("id") String idTecnico){
        TecnicoResponseDTO tecnico = tecnicoService.consultarTecnico(idTecnico);

        return ResponseEntity.status(HttpStatus.OK).body(tecnico);
    }

    @PatchMapping("/{idTecnico}/exames/{idExame}/resultado")
    public ResponseEntity<Void> atualizarResultado(
            @PathVariable("idTecnico") String idTecnico,
            @PathVariable("idExame") String idExame,
            @RequestBody String novoResultado){
        tecnicoService.atualizarResultado(idTecnico,idExame,novoResultado);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PatchMapping("/{id}/desativar")
    public ResponseEntity<Void> desativarTecnico(@PathVariable("id") String idTecnico){
        tecnicoService.desativarTecnico(idTecnico);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
