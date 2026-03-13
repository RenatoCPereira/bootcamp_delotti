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

    // LISTAR USUÁRIOS
    @GetMapping("/listar")
    public String listar(Model model) {

        model.addAttribute("usuarios", service.listar());

        return "listar";
    }

    // ABRIR TELA DE CADASTRO
    @GetMapping("/cadastro")
    public String cadastro(Model model) {

        model.addAttribute("usuario", new UsuarioDto());

        return "cadastro";
    }

    // SALVAR USUÁRIO
    @PostMapping("/salvar")
    public String salvar(@Valid @ModelAttribute("usuario") UsuarioDto usuario,
                         BindingResult result,
                         Model model,
                         RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {

            model.addAttribute("usuario", usuario); // 👈 GARANTE QUE VOLTA COM DADOS

            return "cadastro";
        }

        service.salvar(usuario);

        redirectAttributes.addFlashAttribute("sucesso", "Usuário cadastrado com sucesso!");

        return "redirect:/usuarios/listar";
    }

    // ABRIR TELA DE EDIÇÃO
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {

        UsuarioDto usuario = service.buscar(id);

        model.addAttribute("usuario", usuario);

        return "cadastro";
    }

    // ATUALIZAR USUÁRIO
    @PostMapping("/atualizar/{id}")
    public String atualizar(@PathVariable Long id,
                            @Valid @ModelAttribute("usuario") UsuarioDto usuario,
                            BindingResult result,
                            Model model) {

        if (result.hasErrors()) {

            model.addAttribute("usuario", usuario);

            return "cadastro";
        }

        service.atualizar(id, usuario);

        return "redirect:/usuarios/listar";
    }

    // DELETAR USUÁRIO
    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {

        service.deletar(id);

        return "redirect:/usuarios/listar";
    }

}