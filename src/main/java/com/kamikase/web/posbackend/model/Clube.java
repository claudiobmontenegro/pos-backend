package com.kamikase.web.posbackend.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;

import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
public class Clube implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Informe o nome do clube")
    private String nome;

    @NotBlank(message = "Informe o estado do clube")
    private String estado;

    @Email
    @NotBlank(message = "Informe o email do clube")
    private String email;

    @CNPJ
    @NotBlank(message = "Informe o cnpj do clube")
    private String cpnj;

    @NotNull(message = "Informe a data de criação do clube")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date dataCriacao;
}