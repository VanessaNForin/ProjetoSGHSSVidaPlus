package com.forin.apividaplus.controllers;

import com.forin.apividaplus.dtos.MedicoDTO;
import com.forin.apividaplus.models.pessoas.Medico;
import com.forin.apividaplus.services.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @PostMapping
    public Medico cadastrarMedico(@RequestBody MedicoDTO medico){
        return medicoService.cadastrarMedico(medico);
    }

    @GetMapping("/{id}")
    public Medico consultarMedico(@PathVariable("id") String idMedico){
        return medicoService.consultarMedico(idMedico);
    }

    @DeleteMapping("/{id}")
    private void deletarMedico(@PathVariable("id") String idMedico){
        medicoService.deletarMedico(idMedico);
    }


}
