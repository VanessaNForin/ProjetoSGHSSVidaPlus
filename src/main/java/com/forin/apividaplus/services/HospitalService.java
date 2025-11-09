package com.forin.apividaplus.services;

import com.forin.apividaplus.dtos.HospitalDTO;
import com.forin.apividaplus.models.infraestrutura.Hospital;
import com.forin.apividaplus.repositories.HospitalRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.forin.apividaplus.services.Utils.criarId;

@Service
public class HospitalService {

    @Autowired
    private HospitalRepository hospitalRepository;

    @Transactional
    public Hospital cadastrarHospital(HospitalDTO hospital){
        Hospital novoHospital = new Hospital();

        novoHospital.setIdHospital(criarId(Hospital.class, hospitalRepository.count()));
        novoHospital.setNome(hospital.getNome());
        novoHospital.setEndereco(hospital.getEndereco());
        novoHospital.setTelefone(hospital.getTelefone());

        return hospitalRepository.save(novoHospital);
    }
}
