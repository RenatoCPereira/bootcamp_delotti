package com.example.bootcamp_delotti.service;

import com.example.bootcamp_delotti.model.dto.UsuarioDto;
import com.example.bootcamp_delotti.model.entity.Usuario;
import com.example.bootcamp_delotti.repository.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UsuarioServiceTest {

    @Mock
    private UsuarioRepository repository;

    @InjectMocks
    private UsuarioService service;

    @Test
    void deveSalvarUsuario() {
        UsuarioDto dto = new UsuarioDto("Renato","12345678900","123456","renato@email.com",LocalDate.of(1990,1,1));
        Usuario usuarioSalvo = new Usuario(1L,"Renato","12345678900","123456","renato@email.com",LocalDate.of(1990,1,1));

        when(repository.save(any(Usuario.class))).thenReturn(usuarioSalvo);

        UsuarioDto resultado = service.salvar(dto);

        assertNotNull(resultado);
        assertEquals("Renato", resultado.getNome());
        verify(repository, times(1)).save(any(Usuario.class));
    }

    @Test
    void deveListarUsuarios() {
        Usuario u1 = new Usuario(1L,"Renato","12345678900","123456","renato@email.com",LocalDate.of(1990,1,1));
        Usuario u2 = new Usuario(2L,"Maria","98765432100","123456","maria@email.com",LocalDate.of(1995,5,5));
        when(repository.findAll()).thenReturn(Arrays.asList(u1,u2));

        List<UsuarioDto> resultado = service.listar();

        assertEquals(2, resultado.size());
        assertEquals("Renato", resultado.get(0).getNome());
        verify(repository, times(1)).findAll();
    }

    @Test
    void deveBuscarUsuarioPorId() {
        Usuario u = new Usuario(1L,"Renato","12345678900","123456","renato@email.com",LocalDate.of(1990,1,1));
        when(repository.findById(1L)).thenReturn(Optional.of(u));

        UsuarioDto resultado = service.buscar(1L);

        assertNotNull(resultado);
        assertEquals("Renato", resultado.getNome());
        verify(repository, times(1)).findById(1L);
    }

    @Test
    void deveAtualizarUsuario() {
        Long id = 1L;
        Usuario existente = new Usuario(id,"Renato","12345678900","123456","renato@email.com",LocalDate.of(1990,1,1));
        UsuarioDto dto = new UsuarioDto("Renato Atualizado","12345678900","123456","renato@email.com",LocalDate.of(1990,1,1));
        when(repository.findById(id)).thenReturn(Optional.of(existente));
        when(repository.save(any(Usuario.class))).thenReturn(existente);

        UsuarioDto resultado = service.atualizar(id,dto);

        assertEquals("Renato Atualizado", resultado.getNome());
        verify(repository,times(1)).findById(id);
        verify(repository,times(1)).save(existente);
    }

    @Test
    void deveDeletarUsuario() {
        Long id = 1L;
        doNothing().when(repository).deleteById(id);

        service.deletar(id);

        verify(repository,times(1)).deleteById(id);
    }
}