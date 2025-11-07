package com.forin.apividaplus.services;

import com.forin.apividaplus.dtos.EnfermeiroDTO;
import com.forin.apividaplus.models.pessoas.Enfermeiro;
import com.forin.apividaplus.repositories.EnfermeiroRepository;
import com.forin.apividaplus.repositories.HospitalRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.forin.apividaplus.services.Utils.criarId;
import static com.forin.apividaplus.services.Utils.formatarData;

@Service
public class EnfermeiroService {

    @Autowired
    private EnfermeiroRepository enfermeiroRepository;

    @Autowired
    private HospitalRepository hospitalRepository;

    @Transactional
    public Enfermeiro cadastrarEnfermeiro(EnfermeiroDTO enfermeiro){
        Enfermeiro novoEnfermeiro = new Enfermeiro();

        novoEnfermeiro.setIdEnfermeiro(criarId(Enfermeiro.class, enfermeiroRepository.count()));
        novoEnfermeiro.setCadastroAtivo(true);
        novoEnfermeiro.setNomeCompleto(enfermeiro.getNomeCompleto());
        novoEnfermeiro.setDataNascimento(formatarData(enfermeiro.getDataNascimento()));
        novoEnfermeiro.setCpf(enfermeiro.getCpf());
        novoEnfermeiro.setEndereco(enfermeiro.getEndereco());
        novoEnfermeiro.setTelefone(enfermeiro.getTelefone());
        novoEnfermeiro.setHospitalTrabalho(
                hospitalRepository.findById(enfermeiro.getIdHospitalTrabalho())
                        .orElseThrow(() -> new RuntimeException("Hospital não encontrado"))
        );
        novoEnfermeiro.setIsSupervisora(enfermeiro.getIsSupervisora());
        novoEnfermeiro.setIsPlantonista(enfermeiro.getIsPlantonista());
        novoEnfermeiro.setCoren(enfermeiro.getCoren());

        return enfermeiroRepository.save(novoEnfermeiro);
    }

    public Enfermeiro consultarEnfermeiro(String idEnfermeiro){
        return enfermeiroRepository.findById(idEnfermeiro).orElseThrow(()-> new RuntimeException("Enfermeiro não encontrado"));
    }

    public void deletarEnfermeiro(String idEnfermeiro){
        enfermeiroRepository.deleteById(idEnfermeiro);
    }

}
