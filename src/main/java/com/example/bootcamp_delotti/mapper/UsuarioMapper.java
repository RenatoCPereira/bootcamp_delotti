package com.example.bootcamp_delotti.mapper;

import com.example.bootcamp_delotti.model.dto.UsuarioDto;
import com.example.bootcamp_delotti.model.entity.Usuario;

public class UsuarioMapper {

    public static Usuario toEntity(UsuarioDto dto) {

        Usuario usuario = new Usuario();
        usuario.setId(dto.getId());
        usuario.setNome(dto.getNome());
        usuario.setCpf(dto.getCpf());
        usuario.setSenha(dto.getSenha());
        usuario.setEmail(dto.getEmail());
        usuario.setDataNascimento(dto.getDataNascimento());

        return usuario;
    }

    public static UsuarioDto toDto(Usuario usuario) {

        UsuarioDto dto = new UsuarioDto();
        dto.setId(usuario.getId());
        dto.setNome(usuario.getNome());
        dto.setCpf(usuario.getCpf());
        dto.setSenha(usuario.getSenha());
        dto.setEmail(usuario.getEmail());
        dto.setDataNascimento(usuario.getDataNascimento());

        return dto;
    }
}