package com.forin.apividaplus.services;

import com.forin.apividaplus.models.pessoas.Paciente;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Utils {

    public static String criarId(Class<?> classe, long quantidadeAtual){
        String prefixo;

        switch (classe.getSimpleName()){
            case "Paciente" -> prefixo = "PAC";
            case "Medico" -> prefixo = "MED";
            case "Enfermeiro" -> prefixo = "ENF";
            case "Tecnico" -> prefixo = "TEC";
            case "Administrador" -> prefixo = "ADM";
            default -> prefixo = "GEN";
            }

        return String.format("%s%04d", prefixo, quantidadeAtual + 1);
        }

    public static LocalDate formatarData(String data){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return LocalDate.parse(data, formatter);
    }
}

