package com.forin.apividaplus.services;

import com.forin.apividaplus.dtos.AdministradorInputDTO;
import com.forin.apividaplus.dtos.AdministradorResponseDTO;
import com.forin.apividaplus.models.infraestrutura.Clinica;
import com.forin.apividaplus.models.infraestrutura.Hospital;
import com.forin.apividaplus.models.infraestrutura.Laboratorio;
import com.forin.apividaplus.models.pessoas.Administrador;
import com.forin.apividaplus.repositories.AdministradorRepository;
import com.forin.apividaplus.repositories.ClinicaRepository;
import com.forin.apividaplus.repositories.HospitalRepository;
import com.forin.apividaplus.repositories.LaboratorioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.forin.apividaplus.mappers.AdministradorMapper.toDTO;
import static com.forin.apividaplus.mappers.AdministradorMapper.toModel;
import static com.forin.apividaplus.services.Utils.criarId;
import static com.forin.apividaplus.services.Utils.validarDataNascimento;

@Service
public class AdministradorService {

    @Autowired
    private AdministradorRepository administradorRepository;

    @Autowired
    private HospitalRepository hospitalRepository;

    @Autowired
    private ClinicaRepository clinicaRepository;

    @Autowired
    private LaboratorioRepository laboratorioRepository;

    @Transactional
    public Administrador cadastrarAdministrador(AdministradorInputDTO administrador){
        Administrador novoAdministrador = toModel(administrador);

        novoAdministrador.setIdAdministrador(criarId(Administrador.class, administradorRepository.count()));
        novoAdministrador.setCadastroAtivo(true);
        novoAdministrador.setDataNascimento(validarDataNascimento(administrador.getDataNascimento()));

        //O administrador deve estar vinculado com pelo menos um hospital, clinica e/ou laboratorio
        boolean semHospital = administrador.getIdHospitais() == null || administrador.getIdHospitais().isEmpty();
        boolean semClinica = administrador.getIdClinicas() == null || administrador.getIdClinicas().isEmpty();
        boolean semLaboratorio = administrador.getIdLaboratorios() == null || administrador.getIdLaboratorios().isEmpty();

        if(semHospital && semClinica && semLaboratorio){
            throw new RuntimeException("O administrador deve estar vinculado a um hospita, clínica e/ou laboratório");
        }

        if(!semHospital){
            novoAdministrador.setHospitais(validarHospital(administrador.getIdHospitais()));
        }

        if(!semClinica){
            novoAdministrador.setClinicas(validarClinicas(administrador.getIdClinicas()));
        }

        if(!semLaboratorio){
            novoAdministrador.setLaboratorios(validarLaboratorios(administrador.getIdLaboratorios()));
        }

        return administradorRepository.save(novoAdministrador);
    }

    public AdministradorResponseDTO consultarAdministrador(String idAdministrador){
        Administrador administrador = administradorRepository.findById(idAdministrador)
                .orElseThrow(()-> new RuntimeException("Administrador não encontrado"));

        return toDTO(administrador);
    }

    public void desativarAdministrador(String idAdministrador){
        Administrador administrador = administradorRepository.findById(idAdministrador)
                .orElseThrow(()-> new RuntimeException("Administrador não encontrado"));

        boolean administradorAtivo = administrador.getCadastroAtivo();

        if(!administradorAtivo){
            throw new RuntimeException("Administrador já está desativado");
        }

        administradorRepository.save(administrador);
    }

    private List<Hospital> validarHospital(List<String> idHospitais){
       List<Hospital> listaHospitais = new ArrayList<Hospital>();

       for (String idHospital:idHospitais){
           Hospital hospital = hospitalRepository.findById(idHospital)
                   .orElseThrow(()->new RuntimeException("Hospital não encontrado"));

           boolean hospitalAtivo = hospital.getIsAtivo();

           if(!hospitalAtivo){
               throw new RuntimeException("Hospital não está com cadastro ativo");
           }

           listaHospitais.add(hospital);
       }

       return listaHospitais;
    }

    private List<Clinica> validarClinicas(List<String> idClinicas){
        List<Clinica> listaClinicas = new ArrayList<Clinica>();

        for(String idClinica:idClinicas){
            Clinica clinica = clinicaRepository.findById(idClinica)
                    .orElseThrow(()-> new RuntimeException("Clínica não encontrada"));

            boolean clinicaAtiva = clinica.getIsAtivo();

            if(!clinicaAtiva){
                throw new RuntimeException("Clinica não possui cadastro ativo");
            }

            listaClinicas.add(clinica);
        }

        return listaClinicas;
    }

    private List<Laboratorio> validarLaboratorios(List<String> idLaboratorios){
        List<Laboratorio> listaLaboratorios = new ArrayList<Laboratorio>();

        for(String idLaboratorio:idLaboratorios){
            Laboratorio laboratorio = laboratorioRepository.findById(idLaboratorio)
                    .orElseThrow(()-> new RuntimeException("Laboratorio não encontrada"));

            boolean laboratorioAtivo = laboratorio.getIsAtivo();

            if(!laboratorioAtivo){
                throw new RuntimeException("Laboratorio não possui cadastro ativo");
            }

            listaLaboratorios.add(laboratorio);
        }

        return listaLaboratorios;
    }


}
