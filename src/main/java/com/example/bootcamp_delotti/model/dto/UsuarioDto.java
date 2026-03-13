package com.example.bootcamp_delotti.model.dto;

import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UsuarioDto {

    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    @Size(min = 3, max = 100)
    private String nome;

    @NotBlank(message = "CPF é obrigatório")
    private String cpf;

    @NotBlank(message = "Senha é obrigatória")
    @Size(min = 6)
    private String senha;

    @Email(message = "Email inválido")
    @NotBlank
    private String email;

    @Past
    private LocalDate dataNascimento;
}