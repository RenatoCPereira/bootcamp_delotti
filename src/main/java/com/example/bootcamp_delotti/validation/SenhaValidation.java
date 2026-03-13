package com.example.bootcamp_delotti.validation;

public class SenhaValidation {

    public static void validar(String senha) {

        if (senha == null || senha.isBlank()) {
            throw new IllegalArgumentException("Senha é obrigatória");
        }

        if (senha.length() < 6) {
            throw new IllegalArgumentException("Senha deve ter pelo menos 6 caracteres");
        }
    }
}