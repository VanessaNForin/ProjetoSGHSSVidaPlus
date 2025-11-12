package com.forin.apividaplus.services;

import com.forin.apividaplus.dtos.InternacaoResponseDTO;
import com.forin.apividaplus.dtos.PacienteInputDTO;
import com.forin.apividaplus.dtos.PacienteResponseDTO;
import com.forin.apividaplus.mappers.InternacaoMapper;
import com.forin.apividaplus.models.pessoas.Paciente;
import com.forin.apividaplus.repositories.PacienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.forin.apividaplus.mappers.PacienteMapper.toDTO;
import static com.forin.apividaplus.mappers.PacienteMapper.toModel;
import static com.forin.apividaplus.services.Utils.criarId;
import static com.forin.apividaplus.services.Utils.formatarData;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Transactional
    public Paciente cadastrarPaciente(PacienteInputDTO paciente){
        Paciente novoPaciente = toModel(paciente);

        novoPaciente.setIdPaciente(criarId(Paciente.class, pacienteRepository.count()));
        novoPaciente.setCadastroAtivo(true);
        novoPaciente.setDataNascimento(formatarData(paciente.getDataNascimento()));

        return pacienteRepository.save(novoPaciente);
    }

    public PacienteResponseDTO consultarPaciente(String idPaciente){
        Paciente paciente = pacienteRepository.findById(idPaciente)
                .orElseThrow(()-> new RuntimeException("Paciente não encontrado"));

        return toDTO(paciente);
    }

    public void deletarPaciente(String idPaciente){
        pacienteRepository.deleteById(idPaciente);
    }

    public List<InternacaoResponseDTO> consultarInternacoes(String idPaciente){
        Paciente paciente = pacienteRepository.findById(idPaciente)
                .orElseThrow(()-> new RuntimeException("Paciente não encontrado"));

        return paciente.getInternacoes()
                .stream()
                .map(InternacaoMapper::toDTO) //Mesma coisa que internacao -> InternacaoMapper.toDTO(internacao)
                .collect(Collectors.toList());
    }
}
