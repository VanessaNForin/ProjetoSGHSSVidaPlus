package com.forin.apividaplus.dtos;

import com.forin.apividaplus.models.infraestrutura.Leito;
import com.forin.apividaplus.models.pessoas.Enfermeiro;
import com.forin.apividaplus.models.pessoas.Medico;
import com.forin.apividaplus.models.pessoas.Paciente;
import lombok.Data;

@Data
public class InternacaoResponseDTO {

    private String idInternacao;
    private PacienteResponseDTO paciente;
    private String leito;
    private String isAtivo;
    private String dataEntrada;
    private String dataAlta;
    private String medicoResponsavel;
    private String enfermeiroResponsavel;
    private String prontuario;
}
