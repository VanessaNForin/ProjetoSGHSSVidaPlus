package com.forin.apividaplus.services;

import com.forin.apividaplus.dtos.LeitoDTO;
import com.forin.apividaplus.models.infraestrutura.Hospital;
import com.forin.apividaplus.models.infraestrutura.Leito;
import com.forin.apividaplus.repositories.HospitalRepository;
import com.forin.apividaplus.repositories.LeitoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.forin.apividaplus.services.Utils.criarId;

@Service
public class LeitoService {

    @Autowired
    private LeitoRepository leitoRepository;

    @Autowired
    private HospitalRepository hospitalRepository;

    @Transactional
    public Leito cadastrarLeito(LeitoDTO leito){
        Leito novoLeito = new Leito();

        novoLeito.setIdLeito(criarId(Leito.class, leitoRepository.count()));
        novoLeito.setHospital(validarHospital(leito.getIdHospital()));
        novoLeito.setAndar(leito.getAndar());
        novoLeito.setNumeroLeito(leito.getNumeroLeito());


        return leitoRepository.save(novoLeito);
    }

    private Hospital validarHospital(String idHospital){
        return hospitalRepository.findById(idHospital).orElseThrow(
                ()-> new RuntimeException("Hospital não encontrado"));
    }

}
