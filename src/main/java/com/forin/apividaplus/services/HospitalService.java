package com.forin.apividaplus.services;

import com.forin.apividaplus.dtos.HospitalInputDTO;
import com.forin.apividaplus.dtos.InternacaoResponseDTO;
import com.forin.apividaplus.dtos.LeitoResponseDTO;
import com.forin.apividaplus.mappers.HospitalMapper;
import com.forin.apividaplus.mappers.InternacaoMapper;
import com.forin.apividaplus.mappers.LeitoMapper;
import com.forin.apividaplus.models.infraestrutura.Hospital;
import com.forin.apividaplus.repositories.HospitalRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.forin.apividaplus.mappers.HospitalMapper.toModel;
import static com.forin.apividaplus.services.Utils.criarId;

@Service
public class HospitalService {

    @Autowired
    private HospitalRepository hospitalRepository;

    @Transactional
    public Hospital cadastrarHospital(HospitalInputDTO hospital){
        Hospital novoHospital = toModel(hospital);

        novoHospital.setIdHospital(criarId(Hospital.class, hospitalRepository.count()));

        return hospitalRepository.save(novoHospital);
    }

    public List<LeitoResponseDTO> listarTodosOsLeitos(String idHospital){
        Hospital hospital = hospitalRepository.findById(idHospital).orElseThrow(
                () -> new RuntimeException("Hospital não encontrado")
        );

        return hospital.getLeitos()
                .stream()
                .map(LeitoMapper::toDTO)
                .collect(Collectors.toList());
    }

//    public void deletarHospital(String idHospital){
//        Hospital hospital = hospitalRepository.findById(idHospital).orElseThrow(
//                ()-> new RuntimeException("Hospital Não Encontrado")
//        );
//
//        if (!hospital.getLeitos().isEmpty()){
//            throw new RuntimeException("Não é possível excluir! O hospital possui leitos cadastrados");
//        }
//
//        hospitalRepository.delete(hospital);
//    }
}
