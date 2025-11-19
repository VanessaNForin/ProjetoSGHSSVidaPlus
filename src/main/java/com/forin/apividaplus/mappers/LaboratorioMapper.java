package com.forin.apividaplus.mappers;

import com.forin.apividaplus.dtos.LaboratorioInputDTO;
import com.forin.apividaplus.dtos.LaboratorioResponseDTO;
import com.forin.apividaplus.models.infraestrutura.Laboratorio;

public class LaboratorioMapper {

    public static Laboratorio toModel(LaboratorioInputDTO laboratorio){
        Laboratorio novoLaboratorio = new Laboratorio();

        novoLaboratorio.setNome(laboratorio.getNome());
        novoLaboratorio.setEndereco(laboratorio.getEndereco());
        novoLaboratorio.setTelefone(laboratorio.getTelefone());
        novoLaboratorio.setTipoExameOfertado(laboratorio.getTipoExameOfertado());

        return novoLaboratorio;
    }

    public static LaboratorioResponseDTO toDTO(Laboratorio laboratorio){
        LaboratorioResponseDTO novoLabResponseDTO = new LaboratorioResponseDTO();

        novoLabResponseDTO.setIdLaboratorio(laboratorio.getIdLaboratorio());
        novoLabResponseDTO.setNome(laboratorio.getNome());
        novoLabResponseDTO.setEndereco(laboratorio.getEndereco());
        novoLabResponseDTO.setTelefone(laboratorio.getTelefone());
        novoLabResponseDTO.setTipoExameOfertado(laboratorio.getTipoExameOfertado().getDescricao());

        return novoLabResponseDTO;
    }

}
