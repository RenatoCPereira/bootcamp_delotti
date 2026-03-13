package com.example.bootcamp_delotti.service;

import com.example.bootcamp_delotti.model.dto.UsuarioDto;
import java.util.List;

public interface UsuarioServiceInterface {

    UsuarioDto salvar(UsuarioDto dto);

    List<UsuarioDto> listar();

    UsuarioDto buscar(Long id);

    void deletar(Long id);

    UsuarioDto atualizar(Long id, UsuarioDto dto);
}