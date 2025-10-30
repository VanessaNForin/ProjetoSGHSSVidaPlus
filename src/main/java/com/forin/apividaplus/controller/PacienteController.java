package com.forin.apividaplus.controller;

import com.forin.apividaplus.dto.PacienteDTO;
import com.forin.apividaplus.models.pessoa.Paciente;
import com.forin.apividaplus.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository pacienteRepository;

    @PostMapping
    public Paciente cadastrarPaciente(@RequestBody PacienteDTO pacienteDTO){
        Paciente paciente = new Paciente();

        paciente.setNome(pacienteDTO.getNome());
        paciente.setCpf(pacienteDTO.getCpf());
        paciente.setDataNascimento(pacienteDTO.getDataNascimento());
        paciente.setEndereco(pacienteDTO.getEndereco());
        paciente.setTelefone(pacienteDTO.getTelefone());
        paciente.setEmail(pacienteDTO.getEmail());
        paciente.setCadastroAtivo(true);
        paciente.setIdentificadorPaciente(String.format("PAC%04d", pacienteRepository.count() + 1));
        paciente.setConvenio(pacienteDTO.getConvenio());
        paciente.setProfissao(pacienteDTO.getProfissao());
        paciente.setContatoEmergencia(pacienteDTO.getContatoEmergencia());

        return pacienteRepository.save(paciente);
    }

    @GetMapping("/{identificador}")
    public Paciente consultarPacientePorIdentificador(@PathVariable("identificador") String identificadorPaciente){
        return pacienteRepository.findByIdentificadorPaciente(identificadorPaciente).orElse(null);
    }


}
