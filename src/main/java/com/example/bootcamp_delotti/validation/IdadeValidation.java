package com.example.bootcamp_delotti.validation;

import java.time.LocalDate;
import java.time.Period;

public class IdadeValidation {

    public static void validar(LocalDate dataNascimento) {

        if (dataNascimento == null) {
            throw new IllegalArgumentException("Data de nascimento é obrigatória");
        }

        int idade = Period.between(dataNascimento, LocalDate.now()).getYears();

        if (idade < 18) {
            throw new IllegalArgumentException("Usuário deve ter pelo menos 18 anos");
        }
    }
}