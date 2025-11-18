package com.forin.apividaplus.controllers;

import com.forin.apividaplus.dtos.EnfermeiroInputDTO;
import com.forin.apividaplus.dtos.EnfermeiroResponseDTO;
import com.forin.apividaplus.dtos.InternacaoResponseDTO;
import com.forin.apividaplus.models.pessoas.Enfermeiro;
import com.forin.apividaplus.services.EnfermeiroService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enfermeiros")
public class EnfermeiroController {

    @Autowired
    private EnfermeiroService enfermeiroService;

    @Transactional
    @PostMapping
    public Enfermeiro cadastrarEnfermeiro(@RequestBody EnfermeiroInputDTO enfermeiro){
        return enfermeiroService.cadastrarEnfermeiro(enfermeiro);
    }

    @GetMapping("/{id}")
    public EnfermeiroResponseDTO consultarEnfermeiro(@PathVariable("id") String idEnfermeiro){
        return enfermeiroService.consultarEnfermeiro(idEnfermeiro);
    }

    @GetMapping("/{id}/internacoes")
    public List<InternacaoResponseDTO> consultarInternacoesResponsavel(@PathVariable String idEnfermeiro){
        return enfermeiroService.consultarInternacoesResponsaveis(idEnfermeiro);
    }

    @PatchMapping("/{idEnfermeiro}/internacoes/{idInternacao}/prontuario")
    public void atualizarProntuario(@PathVariable("idEnfermeiro") String idEnfermeiro,
                                    @PathVariable("idInternacao") String idInternacao,
                                    @RequestBody String novoProntuario){
        enfermeiroService.atualizarProntuario(idEnfermeiro,idInternacao,novoProntuario);
    }

//    @DeleteMapping("/{id}")
//    public void deletarEnfermeiro(@PathVariable("id") String idEnfermeiro){
//        enfermeiroService.deletarEnfermeiro(idEnfermeiro);
//    }

}
