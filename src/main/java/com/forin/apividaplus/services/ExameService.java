package com.forin.apividaplus.services;

import com.forin.apividaplus.dtos.ExameInputDTO;
import com.forin.apividaplus.dtos.ExameResponseDTO;
import com.forin.apividaplus.mappers.ExameMapper;
import com.forin.apividaplus.models.atendimento.Exame;
import com.forin.apividaplus.models.enums.CategoriaExame;
import com.forin.apividaplus.models.infraestrutura.Laboratorio;
import com.forin.apividaplus.models.pessoas.Paciente;
import com.forin.apividaplus.models.pessoas.Tecnico;
import com.forin.apividaplus.repositories.ExameRepository;
import com.forin.apividaplus.repositories.LaboratorioRepository;
import com.forin.apividaplus.repositories.PacienteRepository;
import com.forin.apividaplus.repositories.TecnicoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.forin.apividaplus.mappers.ExameMapper.toDTO;
import static com.forin.apividaplus.services.Utils.criarId;
import static com.forin.apividaplus.services.Utils.validarDataHoraAtendimento;

@Service
public class ExameService {

    @Autowired
    private ExameRepository exameRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private LaboratorioRepository laboratorioRepository;

    @Autowired
    private TecnicoRepository tecnicoRepository;

    @Transactional
    public Exame marcarExame(ExameInputDTO exame){
        Exame novoExame = new Exame();

        novoExame.setIdExame(criarId(Exame.class, exameRepository.count()));
        novoExame.setIsAtivo(true);
        novoExame.setPaciente(validarPaciente(exame.getIdPaciente()));
        novoExame.setCategoriaExame(exame.getCategoriaExame());
        novoExame.setLaboratorio(validarLaboratorio(exame.getIdLaboratorio(),novoExame.getCategoriaExame()));
        novoExame.setDataHora(validarDataHoraAtendimento(exame.getDataHora()));
        novoExame.setTecnicoResponsavel(validarTecnico(exame.getIdTecnicoResponsavel(), novoExame.getCategoriaExame()));
        novoExame.setDescricao(exame.getDescricao());

        return novoExame;
    }

    public ExameResponseDTO consultarExame(String idExame){
        Exame exame = exameRepository.findById(idExame).orElseThrow(
                ()-> new RuntimeException("Exame não encontrado")
        );

        return toDTO(exame);
    }

    public void desmarcarExame(String idExame){
        Exame exame = exameRepository.findById(idExame).orElseThrow(
                ()-> new RuntimeException("Exame não encontrado")
        );

        exame.setIsAtivo(false);

        exameRepository.save(exame);
    }

    private Paciente validarPaciente(String idPaciente){
        Paciente paciente = pacienteRepository.findById(idPaciente)
                .orElseThrow(()-> new RuntimeException("Paciente não encontra"));

        boolean pacienteAtivo = paciente.getCadastroAtivo();

        if(!pacienteAtivo){
            throw new RuntimeException("Paciente não tem cadastro ativo");
        }

        return paciente;
    }

    private Laboratorio validarLaboratorio(String idLaboratorio, CategoriaExame categoriaExame){
        Laboratorio laboratorio = laboratorioRepository.findById(idLaboratorio)
                .orElseThrow(()-> new RuntimeException("Laboratório não encontrado"));

        boolean laboratorioAtivo = laboratorio.getIsAtivo();

        if(!laboratorioAtivo){
            throw new RuntimeException("Laboratório não tem cadastro ativo");
        }

        if(!laboratorio.getTipoExameOfertado().equals(categoriaExame)){
            throw new RuntimeException("Esse laboratório não oferece esse tipo de exame");
        }

        return laboratorio;
    }

    private Tecnico validarTecnico(String idTecnico, CategoriaExame categoriaExame){
        Tecnico tecnico = tecnicoRepository.findById(idTecnico)
                .orElseThrow(()-> new RuntimeException("Técnico não encontrado"));

        boolean tecnicoAtivo = tecnico.getCadastroAtivo();

        if(!tecnicoAtivo){
            throw new RuntimeException("Técnico não tem cadastro ativo");
        }

        if (tecnico.getEspecialidade().getCategoriaExame() != categoriaExame){
            throw new RuntimeException("Técnico não é capaz de fazer esse tipo de exame");
        }

        return tecnico;
    }

}
