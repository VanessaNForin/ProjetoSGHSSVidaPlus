package com.forin.apividaplus.mappers;

import com.forin.apividaplus.dtos.ClinicaInputDTO;
import com.forin.apividaplus.dtos.ClinicaResponseDTO;
import com.forin.apividaplus.models.infraestrutura.Clinica;

public class ClinicaMapper {

    public static Clinica toModel(ClinicaInputDTO clinica){
        Clinica novaClinica = new Clinica();

        novaClinica.setNome(clinica.getNome());
        novaClinica.setEndereco(clinica.getEndereco());
        novaClinica.setTelefone(clinica.getTelefone());

        return novaClinica;
    }

    public static ClinicaResponseDTO toDTO(Clinica clinica){
        ClinicaResponseDTO novaClinicaResponseDTO = new ClinicaResponseDTO();

        novaClinicaResponseDTO.setIdClinica(clinica.getIdClinica());
        novaClinicaResponseDTO.setIsAtivo(clinica.getIsAtivo());
        novaClinicaResponseDTO.setNome(clinica.getNome());
        novaClinicaResponseDTO.setEndereco(clinica.getEndereco());
        novaClinicaResponseDTO.setTelefone(clinica.getTelefone());

        return novaClinicaResponseDTO;
    }
}
