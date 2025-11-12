package com.forin.apividaplus.mappers;


import com.forin.apividaplus.dtos.MedicoInputDTO;
import com.forin.apividaplus.dtos.MedicoResponseDTO;
import com.forin.apividaplus.models.pessoas.Medico;
import com.forin.apividaplus.services.Utils;

import static com.forin.apividaplus.services.Utils.formatarDataString;

public class MedicoMapper {

    public static Medico toModel(MedicoInputDTO medico){
        Medico novoMedico = new Medico();

        novoMedico.setNomeCompleto(medico.getNomeCompleto());
        novoMedico.setCpf(medico.getCpf());
        novoMedico.setEndereco(medico.getEndereco());
        novoMedico.setTelefone(medico.getTelefone());
        novoMedico.setEspecialidadeMedica(medico.getEspecialidadeMedica());
        novoMedico.setCrm(medico.getCrm());

        return novoMedico;
    }

    public static MedicoResponseDTO toDTO(Medico medico){
        MedicoResponseDTO MedicoResponseDTO = new MedicoResponseDTO();

        MedicoResponseDTO.setIdMedico(medico.getIdMedico());
        MedicoResponseDTO.setNomeCompleto(medico.getNomeCompleto());
        MedicoResponseDTO.setDataNascimento(formatarDataString(medico.getDataNascimento()));
        MedicoResponseDTO.setCpf(medico.getCpf());
        MedicoResponseDTO.setEndereco(medico.getEndereco());
        MedicoResponseDTO.setTelefone(medico.getTelefone());
        MedicoResponseDTO.setEspecialidadeMedica(medico.getEspecialidadeMedica().getDescricao());
        MedicoResponseDTO.setCrm(medico.getCrm());

        return MedicoResponseDTO;
    }
}
