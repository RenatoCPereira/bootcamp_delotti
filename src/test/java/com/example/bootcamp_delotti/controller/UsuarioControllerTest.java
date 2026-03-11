package com.example.bootcamp_delotti.controller;

import com.example.bootcamp_delotti.dto.UsuarioDto;
import com.example.bootcamp_delotti.service.UsuarioService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UsuarioController.class)
class UsuarioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UsuarioService service;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void deveCriarUsuario() throws Exception {
        UsuarioDto dto = new UsuarioDto("Renato","12345678900","123456","renato@email.com",LocalDate.of(1990,1,1));
        when(service.salvar(any(UsuarioDto.class))).thenReturn(dto);

        mockMvc.perform(post("/usuarios")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("Renato"));

        verify(service,times(1)).salvar(any(UsuarioDto.class));
    }

    @Test
    void deveListarUsuarios() throws Exception {
        UsuarioDto u1 = new UsuarioDto("Renato","12345678900","123456","renato@email.com",LocalDate.of(1990,1,1));
        UsuarioDto u2 = new UsuarioDto("Maria","98765432100","123456","maria@email.com",LocalDate.of(1995,5,5));
        when(service.listar()).thenReturn(Arrays.asList(u1,u2));

        mockMvc.perform(get("/usuarios"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2));

        verify(service,times(1)).listar();
    }

    @Test
    void deveBuscarUsuarioPorId() throws Exception {
        UsuarioDto dto = new UsuarioDto("Renato","12345678900","123456","renato@email.com",LocalDate.of(1990,1,1));
        when(service.buscar(1L)).thenReturn(dto);

        mockMvc.perform(get("/usuarios/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("Renato"));

        verify(service,times(1)).buscar(1L);
    }

    @Test
    void deveAtualizarUsuario() throws Exception {
        UsuarioDto dto = new UsuarioDto("Renato Atualizado","12345678900","123456","renato@email.com",LocalDate.of(1990,1,1));
        when(service.atualizar(eq(1L),any(UsuarioDto.class))).thenReturn(dto);

        mockMvc.perform(put("/usuarios/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("Renato Atualizado"));

        verify(service,times(1)).atualizar(eq(1L),any(UsuarioDto.class));
    }

    @Test
    void deveDeletarUsuario() throws Exception {
        doNothing().when(service).deletar(1L);

        mockMvc.perform(delete("/usuarios/1"))
                .andExpect(status().isOk());

        verify(service,times(1)).deletar(1L);
    }
}