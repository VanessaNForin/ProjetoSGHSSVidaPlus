package com.forin.apividaplus.controllers;

import com.forin.apividaplus.dtos.AdministradorInputDTO;
import com.forin.apividaplus.dtos.AdministradorResponseDTO;
import com.forin.apividaplus.models.pessoas.Administrador;
import com.forin.apividaplus.services.AdministradorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.forin.apividaplus.mappers.AdministradorMapper.toDTO;

@RestController
@RequestMapping("/administradores")
public class AdministradorController {

    @Autowired
    private AdministradorService administradorService;

    @PostMapping
    public ResponseEntity<AdministradorResponseDTO> cadastrarAdministrador(@Valid @RequestBody AdministradorInputDTO administrador){
        Administrador novoAdministrador = administradorService.cadastrarAdministrador(administrador);

        AdministradorResponseDTO administradorDTO = toDTO(novoAdministrador);

        return ResponseEntity.status(HttpStatus.CREATED).body(administradorDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdministradorResponseDTO> consultarAdministrador(@PathVariable("id") String idAdministrador){
        AdministradorResponseDTO administrador = administradorService.consultarAdministrador(idAdministrador);

        return ResponseEntity.status(HttpStatus.OK).body(administrador);
    }

    @PatchMapping("/{id}/desativar")
    public ResponseEntity<Void> desativarAdministrador(@PathVariable("id") String idAdministrador){
        administradorService.desativarAdministrador(idAdministrador);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
