package com.forin.apividaplus.controllers;

import com.forin.apividaplus.dtos.TecnicoDTO;
import com.forin.apividaplus.models.pessoas.Tecnico;
import com.forin.apividaplus.services.TecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tecnicos")
public class TecnicoController {

    @Autowired
    private TecnicoService tecnicoService;

    @PostMapping
    public Tecnico cadastrarTecnico(@RequestBody TecnicoDTO tecnico){
        return tecnicoService.cadastrarTecnico(tecnico);
    }

    @GetMapping("/{id}")
    public Tecnico consultarTecnico(@PathVariable("id") String idTecnico){
        return tecnicoService.consultarTecnico(idTecnico);
    }

//    @DeleteMapping("/{id}")
//    public void deletarTecnico(@PathVariable("id") String idTecnico){
//        tecnicoService.deletarTecnico(idTecnico);
//    }
}
