package com.forin.apividaplus.mappers;

import com.forin.apividaplus.dtos.LeitoInputDTO;
import com.forin.apividaplus.dtos.LeitoResponseDTO;
import com.forin.apividaplus.models.atendimento.Internacao;
import com.forin.apividaplus.models.infraestrutura.Leito;

public class LeitoMapper {

    public static Leito toModel(LeitoInputDTO leito){
        Leito novoLeito = new Leito();

        novoLeito.setAndar(leito.getAndar());
        novoLeito.setNumeroLeito(leito.getNumeroLeito());

        return novoLeito;
    }

    public static LeitoResponseDTO toDTO(Leito leito){
        LeitoResponseDTO leitoResponseDTO = new LeitoResponseDTO();

        leitoResponseDTO.setIdLeito(leito.getIdLeito());
        leitoResponseDTO.setHospital(leito.getHospital().getNome());
        leitoResponseDTO.setAndar(leito.getAndar());
        leitoResponseDTO.setNumeroLeito(leito.getNumeroLeito());

        Internacao internacaoAtual = leito.getInternacao()
                .stream()
                .filter(Internacao::getIsAtivo)
                .findFirst()
                .orElse(null);

        if (internacaoAtual == null){
            leitoResponseDTO.setInternacaoAtual("Não há internação ativa nesse leito");
        } else {
            leitoResponseDTO.setInternacaoAtual(internacaoAtual.getPaciente().getNomeCompleto());
        }

        return leitoResponseDTO;
    }
}
