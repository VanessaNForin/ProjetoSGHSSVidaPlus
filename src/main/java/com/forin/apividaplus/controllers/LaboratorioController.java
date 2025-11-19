package com.forin.apividaplus.controllers;

import com.forin.apividaplus.dtos.LaboratorioInputDTO;
import com.forin.apividaplus.dtos.LaboratorioResponseDTO;
import com.forin.apividaplus.models.infraestrutura.Laboratorio;
import com.forin.apividaplus.services.LaboratorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/laboratorios")
public class LaboratorioController {

    @Autowired
    private LaboratorioService laboratorioService;

    @PostMapping
    public Laboratorio cadastrarLaboratorio(@RequestBody LaboratorioInputDTO laboratorio){
        return laboratorioService.cadastrarLaboratorio(laboratorio);
    }

    @GetMapping("/{id}")
    public LaboratorioResponseDTO consultarLaboratorio(String idLaboratorio){
        return laboratorioService.consultarLaboratorio(idLaboratorio);
    }
}
