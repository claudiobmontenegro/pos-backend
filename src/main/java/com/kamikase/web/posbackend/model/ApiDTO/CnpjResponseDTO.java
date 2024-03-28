package com.kamikase.web.posbackend.model.ApiDTO;

import lombok.Data;

import java.io.Serializable;

@Data
public class CnpjResponseDTO implements Serializable {

    private String cnpj;
    private String tipo;
    private String fantasia;
    private String municipio;
    private String uf;
    private String telefone;
}
