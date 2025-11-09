package com.forin.apividaplus.controllers;

import com.forin.apividaplus.dtos.LeitoDTO;
import com.forin.apividaplus.models.infraestrutura.Leito;
import com.forin.apividaplus.repositories.LeitoRepository;
import com.forin.apividaplus.services.LeitoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/leitos")
public class LeitoController {

    @Autowired
    private LeitoService leitoService;

    @PostMapping
    public Leito cadastrarLeito(@RequestBody LeitoDTO leito){
        return leitoService.cadastrarLeito(leito);
    }
}
