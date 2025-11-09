package com.forin.apividaplus.services;

import com.forin.apividaplus.dtos.InternacaoDTO;
import com.forin.apividaplus.models.atendimento.Internacao;
import com.forin.apividaplus.models.infraestrutura.Leito;
import com.forin.apividaplus.models.pessoas.Enfermeiro;
import com.forin.apividaplus.models.pessoas.Medico;
import com.forin.apividaplus.models.pessoas.Paciente;
import com.forin.apividaplus.repositories.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static com.forin.apividaplus.services.Utils.criarId;

@Service
public class InternacaoService {

    @Autowired
    private InternacaoRepository internacaoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private LeitoRepository leitoRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private EnfermeiroRepository enfermeiroRepository;

    @Transactional
    public Internacao cadastrarInternacao(InternacaoDTO internacao){
        Internacao novaInternacao = new Internacao();

        novaInternacao.setIdInternacao(criarId(Internacao.class, internacaoRepository.count()));
        novaInternacao.setPaciente(validarPaciente(internacao.getIdPaciente()));
        novaInternacao.setLeito(validarLeito(internacao.getIdLeito()));
        novaInternacao.setMedicoResponsavel(validarMedico(internacao.getIdMedico()));
        novaInternacao.setEnfermeiroResponsavel(validarEnfermeiro(internacao.getIdEnfermeiro()));
        novaInternacao.setDataEntrada(LocalDateTime.now());
        novaInternacao.setIsAtivo(true);

        return internacaoRepository.save(novaInternacao);
    }

    //public Internacao darAlta()

    private Paciente validarPaciente(String idPaciente){
        return pacienteRepository.findById(idPaciente).orElseThrow(
                ()-> new RuntimeException("Paciente não encontrado")
        );
    }

    private Leito validarLeito(String idLeito){
        Leito leito = leitoRepository.findById(idLeito).orElse(null);
        if (leito == null){
            throw new RuntimeException("Leito não existe");
        } else if(leito.getInternacao() != null){
            throw new RuntimeException("Leito já ocupado por outra internação");
        } else {
            return leito;
        }
    }

    private Medico validarMedico(String idMedico){
        return medicoRepository.findById(idMedico).orElseThrow(
                () -> new RuntimeException("Médico não encontrado")
        );
    }

    private Enfermeiro validarEnfermeiro(String idEnfermeiro){
        return enfermeiroRepository.findById(idEnfermeiro).orElseThrow(
                ()-> new RuntimeException("Enfermeiro não encontrado")
        );
    }

}
