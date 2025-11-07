package com.forin.apividaplus.controllers;

import com.forin.apividaplus.dtos.EnfermeiroDTO;
import com.forin.apividaplus.models.pessoas.Enfermeiro;
import com.forin.apividaplus.services.EnfermeiroService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/enfermeiros")
public class EnfermeiroController {

    @Autowired
    private EnfermeiroService enfermeiroService;

    @Transactional
    @PostMapping
    public Enfermeiro cadastrarEnfermeiro(@RequestBody EnfermeiroDTO enfermeiro){
        return enfermeiroService.cadastrarEnfermeiro(enfermeiro);
    }

    @GetMapping("/{id}")
    public Enfermeiro consultarEnfermeiro(@PathVariable("id") String idEnfermeiro){
        return enfermeiroService.consultarEnfermeiro(idEnfermeiro);
    }

    @DeleteMapping("/{id}")
    public void deletarEnfermeiro(@PathVariable("id") String idEnfermeiro){
        enfermeiroService.deletarEnfermeiro(idEnfermeiro);
    }
}
