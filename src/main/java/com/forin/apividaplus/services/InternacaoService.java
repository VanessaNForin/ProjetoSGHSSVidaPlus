package com.forin.apividaplus.services;

import com.forin.apividaplus.dtos.InternacaoInputDTO;
import com.forin.apividaplus.dtos.InternacaoResponseDTO;
import com.forin.apividaplus.models.atendimento.Internacao;
import com.forin.apividaplus.models.infraestrutura.Leito;
import com.forin.apividaplus.models.pessoas.Enfermeiro;
import com.forin.apividaplus.models.pessoas.Medico;
import com.forin.apividaplus.models.pessoas.Paciente;
import com.forin.apividaplus.repositories.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static com.forin.apividaplus.mappers.InternacaoMapper.toDTO;
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
    public Internacao cadastrarInternacao(InternacaoInputDTO internacao){
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

    public InternacaoResponseDTO consultarInternacao(String idInternacao){
        Internacao internacao = internacaoRepository.findById(idInternacao)
                .orElseThrow(() -> new RuntimeException("Internação não encontrada"));

        return toDTO(internacao);
    }

    public InternacaoResponseDTO darAlta(String idInternacao){
        Internacao internacao = internacaoRepository.findById(idInternacao)
                .orElseThrow(()-> new RuntimeException("Internação não encontrada"));
        internacao.setIsAtivo(false);
        internacao.setDataAlta(LocalDateTime.now());
        internacaoRepository.save(internacao);

        return toDTO(internacao);
    }

    private Paciente validarPaciente(String idPaciente){
        Paciente paciente =  pacienteRepository.findById(idPaciente).orElseThrow(
                ()-> new RuntimeException("Paciente não encontrado")
        );

        boolean pacienteEmOutroLeito = paciente.getInternacoes()
                .stream().anyMatch(Internacao::getIsAtivo);

        if (pacienteEmOutroLeito){
            throw new RuntimeException("Paciente já está em outro leito");
        }

        boolean pacienteAtivo = paciente.getCadastroAtivo().equals(true);

        if(!pacienteAtivo){
            throw new RuntimeException("Paciente não tem cadastro ativo");
        }

        return paciente;
    }

    private Leito validarLeito(String idLeito){
        Leito leito = leitoRepository.findById(idLeito)
                .orElseThrow(() -> new RuntimeException("Leito não existe"));

        boolean leitoOcupado = leito.getInternacao()
                .stream().anyMatch(Internacao::getIsAtivo);

        if (leitoOcupado) {
            throw new RuntimeException("Leito já ocupado por outra internação");
        }

        return leito;
    }

    private Medico validarMedico(String idMedico){
        Medico medico = medicoRepository.findById(idMedico).orElseThrow(
                () -> new RuntimeException("Médico não encontrado")
        );

        boolean medicoResponsavelPorOutraInternacao = medico.getInternacoesRealizadas()
                .stream().anyMatch(Internacao::getIsAtivo);

        if (medicoResponsavelPorOutraInternacao){
            throw new RuntimeException("Médico já está responsável por outra internação");
        }

        boolean medicoAtivo = medico.getCadastroAtivo().equals(true);

        if(!medicoAtivo){
            throw new RuntimeException("Médico não tem cadastro ativo");
        }

        return medico;
    }


    private Enfermeiro validarEnfermeiro(String idEnfermeiro){
        Enfermeiro enfermeiro = enfermeiroRepository.findById(idEnfermeiro).orElseThrow(
                ()-> new RuntimeException("Enfermeiro não encontrado")
        );

        boolean enfermeiroResponsavelPorOutraInternacao = enfermeiro.getInterncaosResponsavel()
                .stream().anyMatch(Internacao::getIsAtivo);

        if (enfermeiroResponsavelPorOutraInternacao){
            throw new RuntimeException("Enfermeiro já está responsável por outra internação");
        }

        boolean enfermeiroAtivo = enfermeiro.getCadastroAtivo().equals(true);

        if(!enfermeiroAtivo){
            throw new RuntimeException("Enfermeiro não tem cadastro ativo");
        }

        return enfermeiro;
    }

}
