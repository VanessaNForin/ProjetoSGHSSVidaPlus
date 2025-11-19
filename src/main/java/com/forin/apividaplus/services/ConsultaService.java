package com.forin.apividaplus.services;

import com.forin.apividaplus.dtos.ConsultaInputDTO;
import com.forin.apividaplus.dtos.ConsultaResponseDTO;
import com.forin.apividaplus.models.atendimento.Consulta;
import com.forin.apividaplus.models.infraestrutura.Clinica;
import com.forin.apividaplus.models.pessoas.Medico;
import com.forin.apividaplus.models.pessoas.Paciente;
import com.forin.apividaplus.repositories.ClinicaRepository;
import com.forin.apividaplus.repositories.ConsultaRepository;
import com.forin.apividaplus.repositories.MedicoRepository;
import com.forin.apividaplus.repositories.PacienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static com.forin.apividaplus.mappers.ConsultaMapper.toDTO;
import static com.forin.apividaplus.services.Utils.criarId;
import static com.forin.apividaplus.services.Utils.validarDataHoraAtendimento;


@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private ClinicaRepository clinicaRepository;

    @Transactional
    public ConsultaResponseDTO marcarConsulta(ConsultaInputDTO consulta){
        Consulta novaConsulta = new Consulta();

        novaConsulta.setIdConsulta(criarId(Consulta.class, consultaRepository.count()));
        novaConsulta.setLocal(validarClinica(consulta.getIdClinica()));
        novaConsulta.setDataHora(validarDataHoraAtendimento(consulta.getDataHora()));
        novaConsulta.setPaciente(validarPacienteConsulta(consulta.getIdPaciente(), novaConsulta.getDataHora()));
        novaConsulta.setTipoConsulta(consulta.getTipoConsulta());
        novaConsulta.setMedicoResponsavel(validarMedicoConsulta(consulta.getIdMedico(), novaConsulta.getDataHora()));

        consultaRepository.save(novaConsulta);
        return toDTO(novaConsulta);
    }

    public ConsultaResponseDTO consultarConsulta(String idConsulta){
        Consulta consulta = consultaRepository.findById(idConsulta)
                .orElseThrow(
                        ()-> new RuntimeException("Consulta não encontrada")
                );

        return toDTO(consulta);
    }


    public void desmarcarConsulta(String idConsulta){
        Consulta consulta = consultaRepository.findById(idConsulta)
                .orElseThrow(() -> new RuntimeException("Consulta não encontrada"));

        consultaRepository.delete(consulta);
    }

    private Paciente validarPacienteConsulta(String idPaciente, LocalDateTime horaData){
        Paciente paciente =  pacienteRepository.findById(idPaciente).orElseThrow(
                ()-> new RuntimeException("Paciente não encontrado")
        );

        boolean pacienteOcupado = paciente.getConsultas().stream().anyMatch(
                consulta -> consulta.getDataHora().equals(horaData));

        if(pacienteOcupado){
            throw new RuntimeException("Paciente já tem outra consulta nesse horário");
        }

        boolean pacienteAtivo = paciente.getCadastroAtivo().equals(true);

        if(!pacienteAtivo){
            throw new RuntimeException("Paciente não tem cadastro ativo");
        }

        return paciente;
    }

    private Medico validarMedicoConsulta(String idMedico, LocalDateTime dataHora){
        Medico medico = medicoRepository.findById(idMedico).orElseThrow(
                () -> new RuntimeException("Médico não encontrado")
        );

        boolean medicoOcupado = medico.getConsultasRealizadas()
                .stream()
                .anyMatch(consulta -> consulta.getDataHora().equals(dataHora));

        if(medicoOcupado){
            throw new RuntimeException("Médico já tem outra consulta nesse horário");
        }

        boolean medicoAtivo = medico.getCadastroAtivo().equals(true);

        if(!medicoAtivo){
            throw new RuntimeException("Médico não tem cadastro ativo");
        }

        return medico;
    }

    private Clinica validarClinica(String idClinica){

        return clinicaRepository.findById(idClinica)
                .orElseThrow(
                        ()-> new RuntimeException("Clinica não existe")
                );
    }


}
