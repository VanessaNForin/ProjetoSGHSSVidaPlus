package com.forin.apividaplus.controllers;

import com.forin.apividaplus.dtos.PacienteDTO;
import com.forin.apividaplus.models.pessoas.Paciente;
import com.forin.apividaplus.repositories.PacienteRepository;
import com.forin.apividaplus.services.PacienteService;
import jakarta.persistence.PrePersist;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping
    public Paciente cadastrarPaciente(@RequestBody PacienteDTO paciente){
        return pacienteService.cadastrarPaciente(paciente);
    }

    @GetMapping("/{id}")
    public Paciente consultarPaciente(@PathVariable("id") String idPaciente){
        return pacienteService.consultarPaciente(idPaciente);
    }

    @DeleteMapping("/{id}")
    public void deletarPaciente(@PathVariable("id") String idPaciente){
        pacienteService.deletarPaciente(idPaciente);
    }

}
