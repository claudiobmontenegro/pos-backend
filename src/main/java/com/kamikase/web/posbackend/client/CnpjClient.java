package com.kamikase.web.posbackend.client;

import com.kamikase.web.posbackend.model.ApiDTO.CnpjResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "speedio", url = "https://receitaws.com.br/v1/cnpj/")
public interface CnpjClient {

    @GetMapping("{cnpj}")
    CnpjResponseDTO findCnpj(@PathVariable("cnpj") String cnpj);
}
