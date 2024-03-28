package com.kamikase.web.posbackend.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kamikase.web.posbackend.validator.ClubeValidation;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Value;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.xml.transform.Source;
import java.io.Serializable;
import java.util.Date;

@Value
public class ClubeDTO implements Serializable {

    @ClubeValidation(message = "Nome de clube invalido.")
    @NotBlank(message = "Informe o nome do clube")
    String nome;

    @NotBlank(message = "Informe o estado do clube")
    String estado;

    @Email
    @NotBlank(message = "Informe o email do clube")
    String email;

    @CNPJ
    @NotBlank(message = "Informe o cnpj do clube")
    String cnpj;

    @NotNull(message = "Informe a data de criação do clube")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    Date dataCriacao;

}
