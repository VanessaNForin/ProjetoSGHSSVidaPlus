package com.forin.apividaplus.mappers;


import com.forin.apividaplus.dtos.PacienteInputDTO;
import com.forin.apividaplus.dtos.PacienteResponseDTO;
import com.forin.apividaplus.models.pessoas.Paciente;
import com.forin.apividaplus.services.Utils;

import java.time.format.DateTimeFormatter;


public class PacienteMapper {

    public static Paciente toModel(PacienteInputDTO paciente){
        Paciente novoPaciente = new Paciente();

        novoPaciente.setNomeCompleto(paciente.getNomeCompleto());
        novoPaciente.setCpf(paciente.getCpf());
        novoPaciente.setEndereco(paciente.getEndereco());
        novoPaciente.setTelefone(paciente.getTelefone());
        novoPaciente.setProfissao(paciente.getProfissao());
        novoPaciente.setConvenio(paciente.getConvenio());
        novoPaciente.setContatoEmergencia(paciente.getContatoEmergencia());
        novoPaciente.setAlergias(paciente.getAlergias());

        return novoPaciente;
    }

    public static PacienteResponseDTO toDTO(Paciente paciente){
        PacienteResponseDTO pacienteResponseDTO = new PacienteResponseDTO();

        pacienteResponseDTO.setIdPaciente(paciente.getIdPaciente());
        pacienteResponseDTO.setNomeCompleto(paciente.getNomeCompleto());
        pacienteResponseDTO.setDataNascimento(Utils.formatarDataString(paciente.getDataNascimento()));
        pacienteResponseDTO.setCpf(paciente.getCpf());
        pacienteResponseDTO.setEndereco(paciente.getEndereco());
        pacienteResponseDTO.setTelefone(paciente.getTelefone());
        pacienteResponseDTO.setProfissao(paciente.getProfissao());
        pacienteResponseDTO.setConvenio(paciente.getConvenio().getDescricao());
        pacienteResponseDTO.setContatoEmergencia(paciente.getContatoEmergencia());
        pacienteResponseDTO.setAlergias(paciente.getAlergias().stream().toList());

        return pacienteResponseDTO;
    }


}
