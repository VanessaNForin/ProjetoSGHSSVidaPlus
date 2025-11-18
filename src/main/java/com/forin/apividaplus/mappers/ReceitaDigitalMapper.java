package com.forin.apividaplus.mappers;

import com.forin.apividaplus.dtos.ReceitaDigitalResponseDTO;
import com.forin.apividaplus.models.atendimento.ReceitaDigital;
import com.forin.apividaplus.services.Utils;

import static com.forin.apividaplus.services.Utils.formatarDataString;

public class ReceitaDigitalMapper {

    public static ReceitaDigitalResponseDTO toDTO(ReceitaDigital receita){
        ReceitaDigitalResponseDTO novaReceita = new ReceitaDigitalResponseDTO();

        novaReceita.setIdReceita(receita.getIdReceita());
        novaReceita.setConsultaEmissao(receita.getConsultaEmissao().getIdConsulta());
        novaReceita.setDataEmissao(formatarDataString(receita.getDataEmissao()));
        if (receita.getDataVencimento() != null){
            novaReceita.setDataVencimento(formatarDataString(receita.getDataEmissao()));
        } else {
            novaReceita.setDataVencimento("Não há data de vencimento");
        }
        novaReceita.setPaciente(receita.getPaciente().getNomeCompleto());
        novaReceita.setMedicoEmissor(receita.getMedicoEmissor().getNomeCompleto());
        novaReceita.setDescricao(receita.getDescricao());

        return novaReceita;
    }

}
