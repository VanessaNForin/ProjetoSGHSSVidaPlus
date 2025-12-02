package com.forin.apividaplus.mappers;

import com.forin.apividaplus.dtos.LeitoInputDTO;
import com.forin.apividaplus.dtos.LeitoResponseDTO;
import com.forin.apividaplus.models.atendimento.Internacao;
import com.forin.apividaplus.models.infraestrutura.Leito;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

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
        leitoResponseDTO.setIsAtivo(leito.getIsAtivo());
        leitoResponseDTO.setHospital(leito.getHospital().getNome());
        leitoResponseDTO.setAndar(leito.getAndar());
        leitoResponseDTO.setNumeroLeito(leito.getNumeroLeito());

        Internacao internacaoAtual = Optional.ofNullable(leito.getInternacao())
                .orElse(Collections.emptyList())
                .stream()
                .filter(Internacao::getIsAtivo)
                .findFirst()
                .orElse(null);

        leitoResponseDTO.setInternacaoAtual(
                internacaoAtual == null
                        ? "Não há internação ativa nesse leito"
                        : internacaoAtual.getPaciente().getNomeCompleto()
        );

        return leitoResponseDTO;
    }
}
