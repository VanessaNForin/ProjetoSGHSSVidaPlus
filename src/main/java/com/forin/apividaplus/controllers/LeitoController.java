package com.forin.apividaplus.controllers;

import com.forin.apividaplus.dtos.LeitoInputDTO;
import com.forin.apividaplus.dtos.LeitoResponseDTO;
import com.forin.apividaplus.models.infraestrutura.Leito;
import com.forin.apividaplus.services.LeitoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/leitos")
public class LeitoController {

    @Autowired
    private LeitoService leitoService;

    @PostMapping
    public Leito cadastrarLeito(@RequestBody LeitoInputDTO leito){
        return leitoService.cadastrarLeito(leito);
    }

    @GetMapping("/{id}")
    public LeitoResponseDTO consultarLeito(@PathVariable("id") String idLeito){
        return leitoService.consultarLeito(idLeito);
    }

//    @DeleteMapping("/{id}")
//    public void deletarLeito(@PathVariable("id") String idLeito){
//        leitoService.deletarLeito(idLeito);
//    }
}
