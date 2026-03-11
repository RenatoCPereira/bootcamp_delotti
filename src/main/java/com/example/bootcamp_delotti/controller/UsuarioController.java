package com.example.bootcamp_delotti.controller;

import com.example.bootcamp_delotti.dto.UsuarioDto;
import com.example.bootcamp_delotti.service.UsuarioService;
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
    public UsuarioDto salvar(@RequestBody UsuarioDto dto) {
        return service.salvar(dto);
    }

    // ATUALIZAR USUARIO
    @PutMapping("/{id}")
    public UsuarioDto atualizar(@PathVariable Long id, @RequestBody UsuarioDto dto) {
        return service.atualizar(id, dto);
    }

    // DELETAR
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}