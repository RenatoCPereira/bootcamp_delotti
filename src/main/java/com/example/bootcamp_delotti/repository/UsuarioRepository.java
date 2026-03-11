package com.example.bootcamp_delotti.repository;

import com.example.bootcamp_delotti.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByCpf(String cpf);

    Optional<Usuario> findByEmail(String email);

    boolean existsByCpf(String cpf);

}