package com.forin.apividaplus.services;

import com.forin.apividaplus.dtos.LaboratorioInputDTO;
import com.forin.apividaplus.dtos.LaboratorioResponseDTO;
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
    public LaboratorioResponseDTO cadastrarLaboratorio(LaboratorioInputDTO laboratorio){
        Laboratorio novoLaboratorio = toModel(laboratorio);

        novoLaboratorio.setIdLaboratorio(criarId(Laboratorio.class, laboratorioRepository.count()));
        novoLaboratorio.setIsAtivo(true);

        laboratorioRepository.save(novoLaboratorio);
        return toDTO(novoLaboratorio);
    }

    public LaboratorioResponseDTO consultarLaboratorio(String idLaboratorio){
        Laboratorio laboratorio = laboratorioRepository.findById(idLaboratorio)
                .orElseThrow(()-> new RuntimeException("Laboratório não encontrado"));

        return toDTO(laboratorio);
    }

    public void desativarLaboratorio(String idLaboratorio){
        Laboratorio laboratorio = laboratorioRepository.findById(idLaboratorio)
                .orElseThrow(()-> new RuntimeException("Laboratório não encontrado"));

        boolean laboratorioAtivo = laboratorio.getIsAtivo();

        if(!laboratorioAtivo){
            throw new RuntimeException("Laboratorio já está com o cadastro desativado");
        }

        laboratorio.setIsAtivo(false);
        laboratorioRepository.save(laboratorio);
    }


}
