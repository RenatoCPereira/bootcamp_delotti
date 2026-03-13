package com.example.bootcamp_delotti.controller;

import com.example.bootcamp_delotti.model.dto.UsuarioDto;
import com.example.bootcamp_delotti.service.UsuarioService;
import com.example.bootcamp_delotti.validation.CpfValidation;
import com.example.bootcamp_delotti.validation.EmailValidation;
import com.example.bootcamp_delotti.validation.IdadeValidation;
import com.example.bootcamp_delotti.validation.SenhaValidation;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    // LISTAR TODOS
    @GetMapping
    public List<UsuarioDto> listar() {
        return service.listar();
    }

    // BUSCAR POR ID
    @GetMapping("/{id}")
    public UsuarioDto buscar(@PathVariable Long id) {
        return service.buscar(id);
    }

    // CRIAR USUARIO
    @PostMapping
    public UsuarioDto salvar(@Valid @RequestBody UsuarioDto dto) {
        CpfValidation.validar(dto.getCpf());
        EmailValidation.validar(dto.getEmail());
        SenhaValidation.validar(dto.getSenha());
        IdadeValidation.validar(dto.getDataNascimento());
        return service.salvar(dto);
    }

    // ATUALIZAR USUARIO
    @PutMapping("/{id}")
    public UsuarioDto atualizar(@PathVariable Long id, @Valid @RequestBody UsuarioDto dto) {
        CpfValidation.validar(dto.getCpf());
        EmailValidation.validar(dto.getEmail());
        SenhaValidation.validar(dto.getSenha());
        IdadeValidation.validar(dto.getDataNascimento());
        return service.atualizar(id, dto);
    }

    // DELETAR
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}