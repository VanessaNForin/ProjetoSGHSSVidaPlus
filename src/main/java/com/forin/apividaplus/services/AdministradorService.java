package com.forin.apividaplus.services;

import com.forin.apividaplus.dtos.AdministradorDTO;
import com.forin.apividaplus.models.pessoas.Administrador;
import com.forin.apividaplus.models.pessoas.Enfermeiro;
import com.forin.apividaplus.repositories.AdministradorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.forin.apividaplus.services.Utils.criarId;

@Service
public class AdministradorService {

    @Autowired
    private AdministradorRepository administradorRepository;

    @Transactional
    public Administrador cadastrarAdministrador(AdministradorDTO administrador){
        Administrador novoAdministrador = new Administrador();

        novoAdministrador.setIdAdministrador(criarId(Administrador.class, administradorRepository.count()));
        novoAdministrador.setCadastroAtivo(true);
        novoAdministrador.setNomeCompleto(administrador.getNomeCompleto());
        //novoAdministrador.setDataNascimento(formatarData(administrador.getDataNascimento()));
        novoAdministrador.setCpf(administrador.getCpf());
        novoAdministrador.setEndereco(administrador.getEndereco());
        novoAdministrador.setTelefone(administrador.getTelefone());
        novoAdministrador.setDepartamento(administrador.getDepartamento());

        return administradorRepository.save(novoAdministrador);
    }

    public Administrador consultarAdministrador(String idAdministrador){
        return administradorRepository.findById(idAdministrador).orElseThrow(()-> new RuntimeException("Administrador não encontrado"));
    }

//    public void deletarAdministrador(String idAdministrador){
//        administradorRepository.deleteById(idAdministrador);
//    }

}
