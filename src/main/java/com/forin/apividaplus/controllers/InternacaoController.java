package com.forin.apividaplus.controllers;

import com.forin.apividaplus.dtos.InternacaoDTO;
import com.forin.apividaplus.models.atendimento.Internacao;
import com.forin.apividaplus.services.InternacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/internacoes")
public class InternacaoController {

    @Autowired
    private InternacaoService internacaoService;

    @PostMapping
    public Internacao cadastrarInternacao(@RequestBody InternacaoDTO internacao){
        return internacaoService.cadastrarInternacao(internacao);
    }

    //PatchMapping

}
