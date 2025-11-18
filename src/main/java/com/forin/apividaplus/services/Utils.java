package com.forin.apividaplus.services;

import com.forin.apividaplus.models.pessoas.Paciente;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
            case "Consulta" -> prefixo = "CON";
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

    public static LocalDateTime formatarDataHora(String dataHora){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        return LocalDateTime.parse(dataHora, formatter);
    }

    public static String formatarDataHoraString(LocalDateTime dataHora){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return formatter.format(dataHora);
    }

    public static LocalDateTime validarDataHoraAtendimento(String dataHora){
        LocalDateTime dataHoraFormatada = formatarDataHora(dataHora);

        if (dataHoraFormatada.isBefore(LocalDateTime.now())){
            throw new RuntimeException("Só é possível marcar consultas no futuro");
        }

        return dataHoraFormatada;
    }

    public static LocalDate validarDataNascimento(String data){
        LocalDate dataFormatada = formatarData(data);

        if(dataFormatada.isAfter(LocalDate.now())){
            throw new RuntimeException("Só é possível data de nascimento no passado");
        }

        return dataFormatada;
    }



}

