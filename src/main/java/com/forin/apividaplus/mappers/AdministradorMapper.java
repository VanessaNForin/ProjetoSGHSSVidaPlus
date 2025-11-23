package com.forin.apividaplus.mappers;

import com.forin.apividaplus.dtos.AdministradorInputDTO;
import com.forin.apividaplus.dtos.AdministradorResponseDTO;
import com.forin.apividaplus.models.infraestrutura.Clinica;
import com.forin.apividaplus.models.infraestrutura.Hospital;
import com.forin.apividaplus.models.infraestrutura.Laboratorio;
import com.forin.apividaplus.models.pessoas.Administrador;
import com.forin.apividaplus.services.Utils;

import java.util.stream.Collector;
import java.util.stream.Collectors;

import static com.forin.apividaplus.services.Utils.formatarDataString;

public class AdministradorMapper {

    public static Administrador toModel(AdministradorInputDTO administrador){
        Administrador novoAdministrador = new Administrador();

        novoAdministrador.setNomeCompleto(administrador.getNomeCompleto());
        novoAdministrador.setCpf(administrador.getCpf());
        novoAdministrador.setEndereco(administrador.getEndereco());
        novoAdministrador.setTelefone(administrador.getTelefone());
        novoAdministrador.setDepartamento(administrador.getDepartamento());

        return novoAdministrador;
    }

    public static AdministradorResponseDTO toDTO(Administrador administrador){
        AdministradorResponseDTO novoAdmResponseDTO = new AdministradorResponseDTO();

        novoAdmResponseDTO.setIdAdministrador(administrador.getIdAdministrador());
        novoAdmResponseDTO.setNomeCompleto(administrador.getNomeCompleto());
        novoAdmResponseDTO.setDataNascimento(formatarDataString(administrador.getDataNascimento()));
        novoAdmResponseDTO.setCpf(administrador.getCpf());
        novoAdmResponseDTO.setEndereco(administrador.getEndereco());
        novoAdmResponseDTO.setTelefone(administrador.getTelefone());
        novoAdmResponseDTO.setDepartamento(administrador.getDepartamento().getDescricao());

        if(administrador.getHospitais() != null){
            novoAdmResponseDTO.setHospitaisAdministrados(
                    administrador.getHospitais()
                            .stream()
                            .map(Hospital::getNome)
                            .collect(Collectors.toList()));
        }

        if(administrador.getLaboratorios() != null){
            novoAdmResponseDTO.setLaboratorioAdministrados(
                    administrador.getLaboratorios()
                            .stream()
                            .map(Laboratorio::getNome)
                            .collect(Collectors.toList())
            );
        }

        if (administrador.getClinicas() != null){
            novoAdmResponseDTO.setClinicasAdministradas(
                    administrador.getClinicas()
                            .stream()
                            .map(Clinica::getNome)
                            .collect(Collectors.toList())
            );
        }

        return novoAdmResponseDTO;
    }
}
