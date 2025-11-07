package com.forin.apividaplus.services;

import com.forin.apividaplus.dtos.MedicoDTO;
import com.forin.apividaplus.models.pessoas.Medico;
import com.forin.apividaplus.repositories.MedicoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.forin.apividaplus.services.Utils.criarId;
import static com.forin.apividaplus.services.Utils.formatarData;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    @Transactional
    public Medico cadastrarMedico(MedicoDTO medico){
        Medico novoMedico = new Medico();

        novoMedico.setIdMedico(criarId(Medico.class, medicoRepository.count()));
        novoMedico.setCadastroAtivo(true);
        novoMedico.setNomeCompleto(medico.getNomeCompleto());
        novoMedico.setDataNascimento(formatarData(medico.getDataNascimento()));
        novoMedico.setCpf(medico.getCpf());
        novoMedico.setEndereco(medico.getEndereco());
        novoMedico.setTelefone(medico.getTelefone());
        novoMedico.setEspecialidadeMedica(medico.getEspecialidadeMedica());
        novoMedico.setCrm(medico.getCrm());

        return medicoRepository.save(novoMedico);
    }

    public Medico consultarMedico(String idMedico){
        return medicoRepository.findById(idMedico).orElse(null);
    }

    public void deletarMedico(String idMedico){
        medicoRepository.deleteById(idMedico);
    }

}
