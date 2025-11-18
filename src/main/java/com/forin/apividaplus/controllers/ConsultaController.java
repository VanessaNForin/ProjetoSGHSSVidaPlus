package com.forin.apividaplus.controllers;

import com.forin.apividaplus.dtos.ConsultaInputDTO;
import com.forin.apividaplus.dtos.ConsultaResponseDTO;
import com.forin.apividaplus.models.atendimento.Consulta;
import com.forin.apividaplus.services.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    @PostMapping
    public ConsultaResponseDTO marcarConsulta(@RequestBody ConsultaInputDTO consulta){
        return consultaService.marcarConsulta(consulta);
    }

    @GetMapping("/{id}")
    public ConsultaResponseDTO consultarConsulta(@PathVariable("id") String idConsulta){
        return consultaService.consultarConsulta(idConsulta);
    }

    @DeleteMapping("/{id}")
    public void desmarcarConsulta(@PathVariable("id") String idConsulta){
        consultaService.desmarcarConsulta(idConsulta);
    }
}
