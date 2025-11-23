package com.forin.apividaplus.controllers;

import com.forin.apividaplus.dtos.*;
import com.forin.apividaplus.models.atendimento.Internacao;
import com.forin.apividaplus.models.pessoas.Medico;
import com.forin.apividaplus.services.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @PostMapping
    public ResponseEntity<MedicoResponseDTO> cadastrarMedico(@RequestBody MedicoInputDTO medico) {
        MedicoResponseDTO novoMedico = medicoService.cadastrarMedico(medico);

        return ResponseEntity.status(HttpStatus.CREATED).body(novoMedico);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicoResponseDTO> consultarMedico(@PathVariable("id") String idMedico) {
        MedicoResponseDTO medico = medicoService.consultarMedico(idMedico);

        return ResponseEntity.status(HttpStatus.OK).body(medico);
    }

    @GetMapping("/{id}/internacoes")
    public ResponseEntity<List<InternacaoResponseDTO>> consultarInternacoesResponsaveis(@PathVariable("id") String idMedico) {
        List<InternacaoResponseDTO> internacoes = medicoService.consultarInternacoesResponsaveis(idMedico);

        return ResponseEntity.status(HttpStatus.OK).body(internacoes);
    }

    @PatchMapping("/{idMedico}/internacoes/{idInternacao}/prontuario")
    public ResponseEntity<Void> atualizarProntuario(
            @PathVariable("idMedico") String idMedico,
            @PathVariable("idInternacao") String idInternacao,
            @RequestBody String novoProntuario) {
        medicoService.atualizarProntuario(idMedico, idInternacao, novoProntuario);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/{id}/consultas")
    public ResponseEntity<List<ConsultaResponseDTO>> consultarConsultasResponsavel(@PathVariable("id") String idMedico){
        List<ConsultaResponseDTO> consultasResponsavel = medicoService.consultarConsultasResponsavel(idMedico);

        return ResponseEntity.status(HttpStatus.OK).body(consultasResponsavel);
    }

    @GetMapping("/{id}/receitas")
    public ResponseEntity<List<ReceitaDigitalResponseDTO>> consultarReceitasEmitida(String idMedico){
        List<ReceitaDigitalResponseDTO> receitasEmitidas = medicoService.consultarReceitasEmitidas(idMedico);

        return ResponseEntity.status(HttpStatus.OK).body(receitasEmitidas);
    }

    @PatchMapping("/{id}/desativar")
    public ResponseEntity<Void> desativarMedico(String idMedico){
        medicoService.desativarMedico(idMedico);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }




}
