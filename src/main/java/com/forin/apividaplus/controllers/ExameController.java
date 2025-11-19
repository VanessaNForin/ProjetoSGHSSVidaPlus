package com.forin.apividaplus.controllers;

import com.forin.apividaplus.dtos.ExameInputDTO;
import com.forin.apividaplus.models.atendimento.Exame;
import com.forin.apividaplus.services.ExameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exames")
public class ExameController {

    @Autowired
    private ExameService exameService;

    @PostMapping
    public Exame marcarExame(@RequestBody ExameInputDTO exame){
        return exameService.marcarExame(exame);
    }

}
