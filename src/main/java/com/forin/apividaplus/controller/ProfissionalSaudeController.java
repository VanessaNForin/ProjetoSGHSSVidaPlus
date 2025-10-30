package com.forin.apividaplus.controller;

import com.forin.apividaplus.dto.ProfissionalSaudeDTO;
import com.forin.apividaplus.models.pessoa.ProfissionalSaude;
import com.forin.apividaplus.repository.ProfissionalSaudeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profissionais_saude")
public class ProfissionalSaudeController {

    @Autowired
    private ProfissionalSaudeRepository profissionalSaudeRepository;

    @PostMapping
    public ProfissionalSaude cadastrarProfissional(@RequestBody ProfissionalSaudeDTO profissionalSaudeDTO){

        ProfissionalSaude profissionalSaude = new ProfissionalSaude();

        profissionalSaude.setNome(profissionalSaudeDTO.getNome());
        profissionalSaude.setCpf(profissionalSaudeDTO.getCpf());
        profissionalSaude.setDataNascimento(profissionalSaudeDTO.getDataNascimento());
        profissionalSaude.setEndereco(profissionalSaudeDTO.getEndereco());
        profissionalSaude.setTelefone(profissionalSaudeDTO.getTelefone());
        profissionalSaude.setEmail(profissionalSaudeDTO.getEmail());
        profissionalSaude.setCadastroAtivo(true);
        profissionalSaude.setIdentificadorProfissionalSaude(String.format("MED%04d", profissionalSaudeRepository.count() + 1));
        profissionalSaude.setTipoProfissional(profissionalSaudeDTO.getTipoProfissional());
        profissionalSaude.setUnidadeTrabalho(profissionalSaudeDTO.getUnidadeTrabalho());
        profissionalSaude.setTurno(profissionalSaudeDTO.getTurno());
        profissionalSaude.setConselhoProfissional(profissionalSaudeDTO.getConselhoProfissional());
        profissionalSaude.setRegistroProfissional(profissionalSaudeDTO.getRegistroProfissional());
        profissionalSaude.setIsPlantonista(profissionalSaudeDTO.getIsPlantonista());
        profissionalSaude.setIsSupervisor(profissionalSaudeDTO.getIsSupervisor());
        profissionalSaude.setEspecialidade(profissionalSaudeDTO.getEspecialidade());

        return profissionalSaudeRepository.save(profissionalSaude);

    }

    @GetMapping("/{identificadorProfissional}")
    public ProfissionalSaude consultarProfissional(@PathVariable("identificadorProfissional") String identificador){
        return profissionalSaudeRepository.findByIdentificadorProfissionalSaude(identificador).orElse(null);
    }

}
