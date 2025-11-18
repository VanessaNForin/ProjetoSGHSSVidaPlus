package com.forin.apividaplus.controllers;

import com.forin.apividaplus.dtos.AdministradorDTO;
import com.forin.apividaplus.models.pessoas.Administrador;
import com.forin.apividaplus.models.pessoas.Enfermeiro;
import com.forin.apividaplus.services.AdministradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/administradores")
public class AdministradorController {

    @Autowired
    private AdministradorService administradorService;

    @PostMapping
    public Administrador cadastrarAdministrador(@RequestBody AdministradorDTO administrador){
        return administradorService.cadastrarAdministrador(administrador);
    }

    @GetMapping("/{id}")
    public Administrador consultarAdministrador(@PathVariable("id") String idAdministrador){
        return administradorService.consultarAdministrador(idAdministrador);
    }

//    @DeleteMapping("/{id}")
//    public void deletarEnfermeiro(@PathVariable("id") String idAdministrador){
//        administradorService.deletarAdministrador(idAdministrador);
//    }
}
