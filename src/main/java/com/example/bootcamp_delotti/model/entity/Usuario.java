package com.example.bootcamp_delotti.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "tb_usuarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
@ToString(exclude = "senha")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome é obrigatório")
    @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres")
    @Column(nullable = false, length = 100)
    private String nome;

    @NotBlank(message = "O CPF é obrigatório")
    @Size(min = 11, max = 14, message = "CPF inválido")
    @Column(nullable = false, unique = true, length = 14)
    private String cpf;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotBlank(message = "A senha é obrigatória")
    @Size(min = 6, message = "A senha deve ter pelo menos 6 caracteres")
    @Column(nullable = false)
    private String senha;

    @Email(message = "Email inválido")
    @NotBlank(message = "O email é obrigatório")
    @Column(nullable = false, unique = true, length = 150)
    private String email;

    @Past(message = "A data de nascimento deve ser no passado")
    @Column(nullable = false)
    private LocalDate dataNascimento;
}

