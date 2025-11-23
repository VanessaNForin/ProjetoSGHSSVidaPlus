package com.forin.apividaplus.services;

import com.forin.apividaplus.dtos.LeitoInputDTO;
import com.forin.apividaplus.dtos.LeitoResponseDTO;
import com.forin.apividaplus.models.infraestrutura.Hospital;
import com.forin.apividaplus.models.infraestrutura.Leito;
import com.forin.apividaplus.repositories.HospitalRepository;
import com.forin.apividaplus.repositories.LeitoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.forin.apividaplus.mappers.LeitoMapper.toDTO;
import static com.forin.apividaplus.mappers.LeitoMapper.toModel;
import static com.forin.apividaplus.services.Utils.criarId;

@Service
public class LeitoService {

    @Autowired
    private LeitoRepository leitoRepository;

    @Autowired
    private HospitalRepository hospitalRepository;

    @Transactional
    public LeitoResponseDTO cadastrarLeito(LeitoInputDTO leito){
        Leito novoLeito = toModel(leito);

        novoLeito.setIdLeito(criarId(Leito.class, leitoRepository.count()));
        novoLeito.setIsAtivo(true);
        novoLeito.setHospital(validarHospital(leito.getIdHospital()));

        leitoRepository.save(novoLeito);
        return toDTO(novoLeito);
    }

    public LeitoResponseDTO consultarLeito(String idLeito){
        Leito leito = leitoRepository.findById(idLeito).orElseThrow(
                () -> new RuntimeException("Leito não encontrado")
        );

        return toDTO(leito);
    }

    public void desativarLeito(String idLeito){
        Leito leito = leitoRepository.findById(idLeito).orElseThrow(
                () -> new RuntimeException("Leito não encontrado")
        );

        boolean leitoAtivo = leito.getIsAtivo();

        if(!leitoAtivo){
            throw new RuntimeException("Leito já esta´com o cadastro desativado");
        }

        leito.setIsAtivo(false);
        leitoRepository.save(leito);
    }

    private Hospital validarHospital(String idHospital){
        Hospital hospital = hospitalRepository.findById(idHospital).orElseThrow(
                ()-> new RuntimeException("Hospital não encontrado"));

        boolean hospitalAtivo = hospital.getIsAtivo();

        if(!hospitalAtivo){
            throw new RuntimeException("Hospital não tem cadastro ativo");
        }

        return hospital;
    }


}
