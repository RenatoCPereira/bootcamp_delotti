package com.example.bootcamp_delotti.validation;

public class CpfValidation {

    public static void validar(String cpf) {

        if (cpf == null || cpf.isBlank()) {
            throw new IllegalArgumentException("CPF é obrigatório");
        }


        cpf = cpf.replace(".", "").replace("-", "");

        if (cpf.length() != 11) {
            throw new IllegalArgumentException("CPF deve ter 11 dígitos");
        }

        if (!cpf.matches("\\d+")) {
            throw new IllegalArgumentException("CPF deve conter apenas números");
        }
    }
}