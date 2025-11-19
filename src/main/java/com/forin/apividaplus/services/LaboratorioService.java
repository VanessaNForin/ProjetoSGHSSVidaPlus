package com.forin.apividaplus.services;

import com.forin.apividaplus.dtos.LaboratorioInputDTO;
import com.forin.apividaplus.dtos.LaboratorioResponseDTO;
import com.forin.apividaplus.mappers.LaboratorioMapper;
import com.forin.apividaplus.models.infraestrutura.Laboratorio;
import com.forin.apividaplus.repositories.LaboratorioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.forin.apividaplus.mappers.LaboratorioMapper.toDTO;
import static com.forin.apividaplus.mappers.LaboratorioMapper.toModel;
import static com.forin.apividaplus.services.Utils.criarId;

@Service
public class LaboratorioService {

    @Autowired
    private LaboratorioRepository laboratorioRepository;

    @Transactional
    public Laboratorio cadastrarLaboratorio(LaboratorioInputDTO laboratorio){
        Laboratorio novoLaboratorio = toModel(laboratorio);

        novoLaboratorio.setIdLaboratorio(criarId(Laboratorio.class, laboratorioRepository.count()));

        return laboratorioRepository.save(novoLaboratorio);
    }

    public LaboratorioResponseDTO consultarLaboratorio(String idLaboratorio){
        Laboratorio laboratorio = laboratorioRepository.findById(idLaboratorio)
                .orElseThrow(()-> new RuntimeException("Laboratório não encontrado"));

        return toDTO(laboratorio);
    }


}
