package com.forin.apividaplus.controllers;

import com.forin.apividaplus.dtos.InternacaoResponseDTO;
import com.forin.apividaplus.dtos.MedicoInputDTO;
import com.forin.apividaplus.dtos.MedicoResponseDTO;
import com.forin.apividaplus.models.atendimento.Internacao;
import com.forin.apividaplus.models.pessoas.Medico;
import com.forin.apividaplus.services.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @PostMapping
    public Medico cadastrarMedico(@RequestBody MedicoInputDTO medico){
        return medicoService.cadastrarMedico(medico);
    }

    @GetMapping("/{id}")
    public MedicoResponseDTO consultarMedico(@PathVariable("id") String idMedico){
        return medicoService.consultarMedico(idMedico);
    }

    @GetMapping("/{id}/internacoes")
    public List<InternacaoResponseDTO> consultarInternacoesResponsaveis(@PathVariable("id") String idMedico){
        return medicoService.consultarInternacoesResponsaveis(idMedico);
    }

    @PatchMapping("/{idMedico}/internacoes/{idInternacao}/prontuario")
    public void atualizarProntuario(
            @PathVariable("idMedico") String idMedico,
            @PathVariable("idInternacao") String idInternacao,
            @RequestBody String novoProntuario){
        medicoService.atualizarProntuario(idMedico,idInternacao,novoProntuario);
    }

    @DeleteMapping("/{id}")
    private void deletarMedico(@PathVariable("id") String idMedico){
        medicoService.deletarMedico(idMedico);
    }



}
