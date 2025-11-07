package com.forin.apividaplus.services;

import com.forin.apividaplus.dtos.PacienteDTO;
import com.forin.apividaplus.models.pessoas.Paciente;
import com.forin.apividaplus.repositories.PacienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.forin.apividaplus.services.Utils.criarId;
import static com.forin.apividaplus.services.Utils.formatarData;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Transactional
    public Paciente cadastrarPaciente(PacienteDTO paciente){
        Paciente novoPaciente = new Paciente();

        novoPaciente.setIdPaciente(criarId(Paciente.class, pacienteRepository.count()));
        novoPaciente.setCadastroAtivo(true);
        novoPaciente.setNomeCompleto(paciente.getNomeCompleto());
        novoPaciente.setDataNascimento(formatarData(paciente.getDataNascimento()));
        novoPaciente.setCpf(paciente.getCpf());
        novoPaciente.setEndereco(paciente.getEndereco());
        novoPaciente.setTelefone(paciente.getTelefone());
        novoPaciente.setProfissao(paciente.getProfissao());
        novoPaciente.setConvenio(paciente.getConvenio());
        novoPaciente.setContatoEmergencia(paciente.getContatoEmergencia());
        novoPaciente.setAlergias(paciente.getAlergias());

        return pacienteRepository.save(novoPaciente);
    }

    public Paciente consultarPaciente(String idPaciente){
        return pacienteRepository.findById(idPaciente).orElse(null);
    }


    public void deletarPaciente(String idPaciente){
        pacienteRepository.deleteById(idPaciente);
    }
}
