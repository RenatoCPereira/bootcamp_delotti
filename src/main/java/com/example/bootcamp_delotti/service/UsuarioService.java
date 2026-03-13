package com.example.bootcamp_delotti.service;

import com.example.bootcamp_delotti.model.dto.UsuarioDto;
import com.example.bootcamp_delotti.model.entity.Usuario;
import com.example.bootcamp_delotti.mapper.UsuarioMapper;
import com.example.bootcamp_delotti.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService implements UsuarioServiceInterface {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }


    @Override
    public UsuarioDto salvar(UsuarioDto dto) {

        Usuario usuario = UsuarioMapper.toEntity(dto);
        Usuario usuarioSalvo = repository.save(usuario);

        return UsuarioMapper.toDto(usuarioSalvo);
    }


    @Override
    public List<UsuarioDto> listar() {

        return repository.findAll()
                .stream()
                .map(UsuarioMapper::toDto)
                .collect(Collectors.toList());
    }


    @Override
    public UsuarioDto buscar(Long id) {

        Usuario usuario = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        return UsuarioMapper.toDto(usuario);
    }


    @Override
    public void deletar(Long id) {
        repository.deleteById(id);
    }


    @Override
    public UsuarioDto atualizar(Long id, UsuarioDto dto) {

        Usuario usuario = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        usuario.setNome(dto.getNome());
        usuario.setCpf(dto.getCpf());
        usuario.setSenha(dto.getSenha());
        usuario.setEmail(dto.getEmail());
        usuario.setDataNascimento(dto.getDataNascimento());

        Usuario atualizado = repository.save(usuario);

        return UsuarioMapper.toDto(atualizado);
    }
}


