package com.crud.cadastro_usuario.infrastructure.repository;

import com.crud.cadastro_usuario.infrastructure.entitys.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findByEmail(String email);

    // Verificar se um usuario existe pelo email.
    boolean existsByEmail(String email);

    @Transactional
    void deleteByEmail(String email);
}
