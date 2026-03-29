package com.example.bootcamp_delotti.repository;

import com.example.bootcamp_delotti.model.entity.Usuario;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UsuarioRepositoryTest {

    @Autowired
    private UsuarioRepository repository;

    @Test
    void deveSalvarUsuario() {

        Usuario usuario = new Usuario();
        usuario.setNome("Renato");
        usuario.setCpf("12345678900");
        usuario.setEmail("renato@email.com");
        usuario.setSenha("123456");
        usuario.setDataNascimento(LocalDate.of(1990,1,1));

        Usuario usuarioSalvo = repository.save(usuario);

        assertNotNull(usuarioSalvo.getId());
        assertEquals("Renato", usuarioSalvo.getNome());
    }

    @Test
    void deveBuscarUsuarioPorCpf() {

        Usuario usuario = new Usuario();
        usuario.setNome("Renato");
        usuario.setCpf("12345678900");
        usuario.setEmail("renato@email.com");
        usuario.setSenha("123456");
        usuario.setDataNascimento(LocalDate.of(1990,1,1)); // 👈 CORREÇÃO

        repository.save(usuario);

        Optional<Usuario> resultado = repository.findByCpf("12345678900");

        assertTrue(resultado.isPresent());
        assertEquals("Renato", resultado.get().getNome());
    }
}