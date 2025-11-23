package com.forin.apividaplus.services;

import com.forin.apividaplus.dtos.ClinicaInputDTO;
import com.forin.apividaplus.dtos.ClinicaResponseDTO;
import com.forin.apividaplus.dtos.ConsultaResponseDTO;
import com.forin.apividaplus.mappers.ClinicaMapper;
import com.forin.apividaplus.mappers.ConsultaMapper;
import com.forin.apividaplus.models.infraestrutura.Clinica;
import com.forin.apividaplus.repositories.ClinicaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.forin.apividaplus.mappers.ClinicaMapper.toDTO;
import static com.forin.apividaplus.mappers.ClinicaMapper.toModel;

@Service
public class ClinicaService {

    @Autowired
    private ClinicaRepository clinicaRepository;

    @Transactional
    public Clinica cadastrarClinica(ClinicaInputDTO clinica){
        Clinica novaClinica = toModel(clinica);

        novaClinica.setIdClinica(Utils.criarId(Clinica.class, clinicaRepository.count()));
        novaClinica.setIsAtivo(true);

        return clinicaRepository.save(novaClinica);
    }

    public ClinicaResponseDTO consultarClinica(String idClinica){
        Clinica clinica = clinicaRepository.findById(idClinica).orElseThrow(
                ()-> new RuntimeException("Clínica não encontrada")
        );

        return toDTO(clinica);
    }

    public List<ConsultaResponseDTO> consultarConsultasClinica(String idClinica){
        Clinica clinica = clinicaRepository.findById(idClinica).orElseThrow(
                ()-> new RuntimeException("Clinica não encontrada")
        );

        return clinica.getConsultas()
                .stream()
                .map(ConsultaMapper::toDTO)
                .collect(Collectors.toList());
    }

    public void desativarClinica(String idClinica){
        Clinica clinica = clinicaRepository.findById(idClinica).orElseThrow(
                ()-> new RuntimeException("Clinica não encontrada")
        );
        boolean clinicaAtiva = clinica.getIsAtivo();

        if(!clinicaAtiva){
            throw new RuntimeException("Clinica já está com o cadastro desativado");
        }

        clinica.setIsAtivo(false);
        clinicaRepository.save(clinica);
    }
}
