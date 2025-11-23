package com.forin.apividaplus.services;

import com.forin.apividaplus.dtos.ReceitaDigitalInputDTO;
import com.forin.apividaplus.dtos.ReceitaDigitalResponseDTO;
import com.forin.apividaplus.mappers.ReceitaDigitalMapper;
import com.forin.apividaplus.models.atendimento.Consulta;
import com.forin.apividaplus.models.atendimento.ReceitaDigital;
import com.forin.apividaplus.repositories.ConsultaRepository;
import com.forin.apividaplus.repositories.ReceitaDigitalRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

import static com.forin.apividaplus.mappers.ReceitaDigitalMapper.toDTO;
import static com.forin.apividaplus.services.Utils.*;

@Service
public class ReceitaDigitalService {

    @Autowired
    private ReceitaDigitalRepository receitaDigitalRepository;

    @Autowired
    private ConsultaRepository consultaRepository;

    @Transactional
    public ReceitaDigitalResponseDTO emitirReceitaDigital(ReceitaDigitalInputDTO receita){
        ReceitaDigital novaReceita = new ReceitaDigital();

        novaReceita.setIdReceita(criarId(ReceitaDigital.class, receitaDigitalRepository.count()));
        novaReceita.setConsultaEmissao(validarConsulta(receita.getIdConsulta()));
        novaReceita.setPaciente(novaReceita.getConsultaEmissao().getPaciente());
        novaReceita.setMedicoEmissor(novaReceita.getConsultaEmissao().getMedicoResponsavel());
        novaReceita.setDataEmissao(novaReceita.getConsultaEmissao().getDataHora().toLocalDate());
        if (receita.getDataVencimento() != null && !receita.getDataVencimento().isBlank()) {
            novaReceita.setDataVencimento(validarDataVencimento(receita.getDataVencimento(), novaReceita.getDataEmissao()));
        } else {
            novaReceita.setDataVencimento(null);
        }
        novaReceita.setDescricao(receita.getDescricao());

        receitaDigitalRepository.save(novaReceita);
        return toDTO(novaReceita);
    }

    public ReceitaDigitalResponseDTO consultarReceita(String idReceita){
        ReceitaDigital receitaDigital = receitaDigitalRepository.findById(idReceita)
                .orElseThrow(()-> new RuntimeException("Receita Digital Não Encontada"));

        return toDTO(receitaDigital);
    }

    private Consulta validarConsulta(String idConsulta){
        return consultaRepository.findById(idConsulta).orElseThrow(
                ()-> new RuntimeException("Consulta não encontrada")
        );
    }

    private LocalDate validarDataVencimento(String dataVencimento, LocalDate dataEmissao){
        LocalDate dataVencimentoFormatada = formatarData(dataVencimento);

        if (dataVencimentoFormatada.isBefore(dataEmissao)){
            throw new RuntimeException("A DATA DE VENCIMENTO não pode ser ANTES da DATA DE EMISSÃO");
        }

        return dataVencimentoFormatada;
    }
}
