package com.forin.apividaplus.mappers;


import com.forin.apividaplus.dtos.EnfermeiroInputDTO;
import com.forin.apividaplus.dtos.EnfermeiroResponseDTO;
import com.forin.apividaplus.models.pessoas.Enfermeiro;
import com.forin.apividaplus.services.Utils;

import static com.forin.apividaplus.services.Utils.formatarData;
import static com.forin.apividaplus.services.Utils.formatarDataString;

public class EnfermeiroMapper {

    public static Enfermeiro toModel(EnfermeiroInputDTO enfermeiro){
        Enfermeiro novoEnfermeiro = new Enfermeiro();

        novoEnfermeiro.setNomeCompleto(enfermeiro.getNomeCompleto());
        novoEnfermeiro.setCpf(enfermeiro.getCpf());
        novoEnfermeiro.setEndereco(enfermeiro.getEndereco());
        novoEnfermeiro.setTelefone(enfermeiro.getTelefone());
        novoEnfermeiro.setIsSupervisora(enfermeiro.getIsSupervisora());
        novoEnfermeiro.setIsPlantonista(enfermeiro.getIsPlantonista());
        novoEnfermeiro.setCoren(enfermeiro.getCoren());

        return novoEnfermeiro;
    }

    public static EnfermeiroResponseDTO toDTO(Enfermeiro enfermeiro){
        EnfermeiroResponseDTO enfermeiroResponseDTO = new EnfermeiroResponseDTO();

        enfermeiroResponseDTO.setIdEnfermeiro(enfermeiro.getIdEnfermeiro());
        enfermeiroResponseDTO.setNomeCompleto(enfermeiro.getNomeCompleto());
        enfermeiroResponseDTO.setDataNascimento(formatarDataString(enfermeiro.getDataNascimento()));
        enfermeiroResponseDTO.setCpf(enfermeiro.getCpf());
        enfermeiroResponseDTO.setEndereco(enfermeiro.getEndereco());
        enfermeiroResponseDTO.setTelefone(enfermeiro.getTelefone());
        enfermeiroResponseDTO.setHospitalTrabalho(enfermeiro.getHospitalTrabalho().getNome());

        String plantonista;
        if (enfermeiro.getIsPlantonista()){
            plantonista = "Plantonista";
        } else {
            plantonista = "Não é plantonista";
        }

        enfermeiroResponseDTO.setIsPlantonista(plantonista);

        String supervisor;
        if (enfermeiro.getIsSupervisora()){
            supervisor = "Supervisor(a)";
        } else {
            supervisor = "Não é supervisor";
        }

        enfermeiroResponseDTO.setIsSupervisora(supervisor);
        enfermeiroResponseDTO.setCoren(enfermeiro.getCoren());

        return enfermeiroResponseDTO;
    }
}
