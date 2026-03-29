package com.example.bootcamp_delotti.controller;

import com.example.bootcamp_delotti.model.dto.UsuarioDto;
import com.example.bootcamp_delotti.service.UsuarioService;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/usuarios")
public class UsuarioPageController {

    private final UsuarioService service;

    public UsuarioPageController(UsuarioService service) {
        this.service = service;
    }


    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("usuarios", service.listar());
        return "listar";
    }


    @GetMapping("/cadastro")
    public String cadastro(Model model) {
        model.addAttribute("usuario", new UsuarioDto());
        return "cadastro";
    }


    @PostMapping("/salvar")
    public String salvar(@Valid @ModelAttribute("usuario") UsuarioDto usuario,
                         BindingResult result,
                         Model model,
                         RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            return "cadastro";
        }

        service.salvar(usuario);
        redirectAttributes.addFlashAttribute("sucesso", "Usuário cadastrado com sucesso!");
        return "redirect:/usuarios/listar";
    }


    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("usuario", service.buscar(id));
        return "cadastro";
    }


    @PostMapping("/atualizar/{id}")
    public String atualizar(@PathVariable Long id,
                            @Valid @ModelAttribute("usuario") UsuarioDto usuario,
                            BindingResult result) {

        if (result.hasErrors()) {
            return "cadastro";
        }

        service.atualizar(id, usuario);
        return "redirect:/usuarios/listar";
    }


    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        service.deletar(id);
        return "redirect:/usuarios/listar";
    }
}