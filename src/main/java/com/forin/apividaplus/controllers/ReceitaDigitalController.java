package com.forin.apividaplus.controllers;

import com.forin.apividaplus.dtos.ReceitaDigitalInputDTO;
import com.forin.apividaplus.models.atendimento.ReceitaDigital;
import com.forin.apividaplus.services.ReceitaDigitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/receitas-digitais")
public class ReceitaDigitalController {

    @Autowired
    private ReceitaDigitalService receitaDigitalService;

    @PostMapping
    public ReceitaDigital emitirReceitaDigital(@RequestBody ReceitaDigitalInputDTO receita){
        return receitaDigitalService.emitirReceitaDigital(receita);
    }
}
