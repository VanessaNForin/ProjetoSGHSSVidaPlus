package com.forin.apividaplus.controllers;

import com.forin.apividaplus.dtos.InternacaoResponseDTO;
import com.forin.apividaplus.dtos.PacienteInputDTO;
import com.forin.apividaplus.dtos.PacienteResponseDTO;
import com.forin.apividaplus.models.pessoas.Paciente;
import com.forin.apividaplus.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping
    public Paciente cadastrarPaciente(@RequestBody PacienteInputDTO paciente){
        return pacienteService.cadastrarPaciente(paciente);
    }

    @GetMapping("/{id}")
    public PacienteResponseDTO consultarPaciente(@PathVariable("id") String idPaciente){
        return pacienteService.consultarPaciente(idPaciente);
    }

    @GetMapping("/{id}/internacoes")
    public List<InternacaoResponseDTO> consultarInternacoes(@PathVariable("id") String idPaciente){
        return pacienteService.consultarInternacoes(idPaciente);
    }

    @DeleteMapping("/{id}")
    public void deletarPaciente(@PathVariable("id") String idPaciente){
        pacienteService.deletarPaciente(idPaciente);
    }


}
