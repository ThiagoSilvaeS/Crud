package com.crud.cadastro_usuario.business;

import com.crud.cadastro_usuario.infrastructure.entitys.Usuario;
import com.crud.cadastro_usuario.infrastructure.exception.UsuarioNaoEncontradoException;
import com.crud.cadastro_usuario.infrastructure.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }


    public void salvarUsuario(Usuario usuario){
        repository.saveAndFlush(usuario);
    }

    public Usuario buscarUsuarioPorEmail(String email){

        return  repository.findByEmail(email).orElseThrow(
                () -> new RuntimeException("email não encotrado")
        );
    }
    public void deletarUsuarioPorEmail(String email){
        if (!repository.existsByEmail(email)){
            throw new UsuarioNaoEncontradoException("Usuario não encontrado para deletar");
        }
        repository.deleteByEmail(email);
    }


    public void atualizarUsuarioPorId(Integer id, Usuario usuario){
        Usuario usuarioEntity = repository.findById(id).orElseThrow(() ->
                new RuntimeException("Usuario não encontrado"));
        Usuario usuarioAtualizado = Usuario.builder()
                .email(usuario.getEmail() != null ? usuario.getEmail() :
                        usuarioEntity.getEmail())
                .nome(usuario.getNome() != null ? usuario.getNome() :
                        usuarioEntity.getNome())
                .id(usuarioEntity.getId())
                .build();

        repository.saveAndFlush(usuarioAtualizado);
    }
}
