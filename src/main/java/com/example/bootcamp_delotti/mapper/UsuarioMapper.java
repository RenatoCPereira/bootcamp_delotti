package com.example.bootcamp_delotti.mapper;

import com.example.bootcamp_delotti.model.dto.UsuarioDto;
import com.example.bootcamp_delotti.model.entity.Usuario;

public class UsuarioMapper {

    public static Usuario toEntity(UsuarioDto dto) {

        Usuario usuario = new Usuario();
        usuario.setNome(dto.getNome());
        usuario.setCpf(dto.getCpf());
        usuario.setSenha(dto.getSenha());
        usuario.setEmail(dto.getEmail());
        usuario.setDataNascimento(dto.getDataNascimento());

        return usuario;
    }

    public static UsuarioDto toDto(Usuario usuario) {
        return UsuarioDto.builder()
                .id(usuario.getId())
                .nome(usuario.getNome())
                .cpf(usuario.getCpf())
                .senha(usuario.getSenha())
                .email(usuario.getEmail())
                .dataNascimento(usuario.getDataNascimento())
                .build();
    }
}