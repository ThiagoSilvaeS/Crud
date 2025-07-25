package com.crud.cadastro_usuario.infrastructure.entitys;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "usuario")
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "email", unique = true, nullable = false)
    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Email Invalido")
    private String email;

    @Column(name = "nome", nullable = false)
    @NotBlank(message = "Nome é obrigatório")
    private String nome;

}
