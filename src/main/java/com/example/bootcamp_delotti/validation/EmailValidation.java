package com.example.bootcamp_delotti.validation;

public class EmailValidation {

    public static void validar(String email) {

        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email é obrigatório");
        }

        if (!email.contains("@") || !email.contains(".")) {
            throw new IllegalArgumentException("Email inválido");
        }
    }
}