package com.example.bootcamp_delotti.service;

import com.example.bootcamp_delotti.dto.UsuarioDto;
import com.example.bootcamp_delotti.entity.Usuario;
import com.example.bootcamp_delotti.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public UsuarioDto salvar(UsuarioDto dto) {

        Usuario usuario = new Usuario();
        usuario.setNome(dto.getNome());
        usuario.setCpf(dto.getCpf());
        usuario.setSenha(dto.getSenha());
        usuario.setEmail(dto.getEmail());
        usuario.setDataNascimento(dto.getDataNascimento());

        Usuario usuarioSalvo = repository.save(usuario);

        return converterParaDto(usuarioSalvo);
    }

    public List<UsuarioDto> listar() {

        return repository.findAll()
                .stream()
                .map(this::converterParaDto)
                .collect(Collectors.toList());
    }

    public UsuarioDto buscar(Long id) {

        Usuario usuario = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        return converterParaDto(usuario);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    public UsuarioDto atualizar(Long id, UsuarioDto dto) {

        Usuario usuario = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        usuario.setNome(dto.getNome());
        usuario.setCpf(dto.getCpf());
        usuario.setSenha(dto.getSenha());
        usuario.setEmail(dto.getEmail());
        usuario.setDataNascimento(dto.getDataNascimento());

        Usuario atualizado = repository.save(usuario);

        return converterParaDto(atualizado);
    }

    private UsuarioDto converterParaDto(Usuario usuario) {

        UsuarioDto dto = new UsuarioDto();
        dto.setNome(usuario.getNome());
        dto.setCpf(usuario.getCpf());
        dto.setSenha(usuario.getSenha());
        dto.setEmail(usuario.getEmail());
        dto.setDataNascimento(usuario.getDataNascimento());

        return dto;
    }
}