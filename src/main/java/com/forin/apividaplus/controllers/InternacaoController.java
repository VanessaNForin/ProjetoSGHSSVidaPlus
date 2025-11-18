package com.forin.apividaplus.controllers;

import com.forin.apividaplus.dtos.InternacaoInputDTO;
import com.forin.apividaplus.dtos.InternacaoResponseDTO;
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
    public Internacao cadastrarInternacao(@RequestBody InternacaoInputDTO internacao){
        return internacaoService.cadastrarInternacao(internacao);
    }

    @PatchMapping("/{id}/alta")
    public InternacaoResponseDTO darAltA(@PathVariable("id") String idInternacao){
        return internacaoService.darAlta(idInternacao);
    }

    @GetMapping("/{id}")
    public InternacaoResponseDTO consultarInternacao(@PathVariable("id") String idInternacao){
        return internacaoService.consultarInternacao(idInternacao);
    }

}
