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
            case "Hospital" -> prefixo = "HOS";
            case "Clinica" -> prefixo = "CLI";
            case "Laboratorio" -> prefixo = "LAB";
            case "Leito" -> prefixo = "LEI";
            case "ReceitaDigital" -> prefixo = "RD";
            case "Internacao" -> prefixo = "INT";
            default -> prefixo = "GEN";
            }

        return String.format("%s%04d", prefixo, quantidadeAtual + 1);
        }

    public static LocalDate formatarData(String data){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return LocalDate.parse(data, formatter);
    }

    public static String formatarDataString(LocalDate localDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return formatter.format(localDate);
    }
}

