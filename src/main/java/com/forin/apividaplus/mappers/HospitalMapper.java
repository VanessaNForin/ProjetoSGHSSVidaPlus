package com.forin.apividaplus.mappers;

import com.forin.apividaplus.dtos.HospitalInputDTO;
import com.forin.apividaplus.dtos.HospitalResponseDTO;
import com.forin.apividaplus.models.infraestrutura.Hospital;

public class HospitalMapper {

    public static Hospital toModel(HospitalInputDTO hospital){
        Hospital novoHospital = new Hospital();

        novoHospital.setNome(hospital.getNome());
        novoHospital.setEndereco(hospital.getEndereco());
        novoHospital.setTelefone(hospital.getTelefone());

        return novoHospital;
    }

    public static HospitalResponseDTO toDTO(Hospital hospital){
        HospitalResponseDTO hospitalResponseDTO = new HospitalResponseDTO();

        hospitalResponseDTO.setIdHospital(hospital.getIdHospital());
        hospitalResponseDTO.setNome(hospital.getNome());
        hospitalResponseDTO.setEndereco(hospital.getEndereco());
        hospitalResponseDTO.setTelefone(hospital.getTelefone());

        return hospitalResponseDTO;
    }

}
