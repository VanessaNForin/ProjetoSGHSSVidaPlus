package com.forin.apividaplus.controllers;

import com.forin.apividaplus.dtos.*;
import com.forin.apividaplus.models.pessoas.Paciente;
import com.forin.apividaplus.services.PacienteService;
import com.forin.apividaplus.services.ReceitaDigitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping
    public ResponseEntity<PacienteResponseDTO> cadastrarPaciente(@RequestBody PacienteInputDTO paciente){
        PacienteResponseDTO novoPaciente = pacienteService.cadastrarPaciente(paciente);

        return ResponseEntity.status(HttpStatus.CREATED).body(novoPaciente);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteResponseDTO> consultarPaciente(@PathVariable("id") String idPaciente){
        PacienteResponseDTO paciente = pacienteService.consultarPaciente(idPaciente);

        return ResponseEntity.status(HttpStatus.OK).body(paciente);
    }

    @GetMapping("/{id}/internacoes")
    public ResponseEntity<List<InternacaoResponseDTO>> consultarInternacoes(@PathVariable("id") String idPaciente){
        List<InternacaoResponseDTO> listaInternacoes = pacienteService.consultarInternacoes(idPaciente);

        return ResponseEntity.status(HttpStatus.OK).body(listaInternacoes);
    }

    @GetMapping("/{id}/consultas")
    public ResponseEntity<List<ConsultaResponseDTO>> consultarConsultas(@PathVariable("id") String idPaciente){
        List<ConsultaResponseDTO> listaConsultas = pacienteService.consultarConsultas(idPaciente);

        return ResponseEntity.status(HttpStatus.OK).body(listaConsultas);
    }

    @GetMapping("/{id}/receitas")
    public ResponseEntity<List<ReceitaDigitalResponseDTO>> consultarReceitas(@PathVariable("id") String idPaciente){
        List<ReceitaDigitalResponseDTO> listaReceitas = pacienteService.consultarReceitas(idPaciente);

        return ResponseEntity.status(HttpStatus.OK).body(listaReceitas);
    }

    @PatchMapping("/{id}/desativar")
    public ResponseEntity<Void> desativarCadastroPaciente(@PathVariable("id") String idPaciente){
        pacienteService.desativarPaciente(idPaciente);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
