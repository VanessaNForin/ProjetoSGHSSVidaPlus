package com.forin.apividaplus.controllers;

import com.forin.apividaplus.dtos.EnfermeiroInputDTO;
import com.forin.apividaplus.dtos.EnfermeiroResponseDTO;
import com.forin.apividaplus.dtos.InternacaoResponseDTO;
import com.forin.apividaplus.models.pessoas.Enfermeiro;
import com.forin.apividaplus.services.EnfermeiroService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.forin.apividaplus.mappers.EnfermeiroMapper.toDTO;

@RestController
@RequestMapping("/enfermeiros")
public class EnfermeiroController {

    @Autowired
    private EnfermeiroService enfermeiroService;

    @Transactional
    @PostMapping
    public ResponseEntity<EnfermeiroResponseDTO> cadastrarEnfermeiro(@RequestBody EnfermeiroInputDTO enfermeiro){
        Enfermeiro enfermeiroCadastrado = enfermeiroService.cadastrarEnfermeiro(enfermeiro);

        EnfermeiroResponseDTO enfermeiroDTO = toDTO(enfermeiroCadastrado);

        return ResponseEntity.status(HttpStatus.CREATED).body(enfermeiroDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnfermeiroResponseDTO> consultarEnfermeiro(@PathVariable("id") String idEnfermeiro){
        EnfermeiroResponseDTO enfermeiroProcurado = enfermeiroService.consultarEnfermeiro(idEnfermeiro);

        return ResponseEntity.status(HttpStatus.OK).body(enfermeiroProcurado);
    }

    @GetMapping("/{id}/internacoes")
    public ResponseEntity<List<InternacaoResponseDTO>> consultarInternacoesResponsavel(@PathVariable String idEnfermeiro){
        List<InternacaoResponseDTO> internacoesResponsavel = enfermeiroService.consultarInternacoesResponsaveis(idEnfermeiro);

        return ResponseEntity.status(HttpStatus.OK).body(internacoesResponsavel);
    }

    @PatchMapping("/{idEnfermeiro}/internacoes/{idInternacao}/prontuario")
    public ResponseEntity<InternacaoResponseDTO> atualizarProntuario(
            @PathVariable("idEnfermeiro") String idEnfermeiro,
            @PathVariable("idInternacao") String idInternacao,
            @RequestBody String novoProntuario)
    {
        InternacaoResponseDTO internacaoAtualizada = enfermeiroService
                .atualizarProntuario(idEnfermeiro,idInternacao,novoProntuario);

        return ResponseEntity.status(HttpStatus.OK).body(internacaoAtualizada);
    }

    @PatchMapping("/{id}/desativar")
    public ResponseEntity<Void> desativarEnfermeiro(@PathVariable("id") String idEnfermeiro){
        enfermeiroService.desativarEnfermeiro(idEnfermeiro);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
