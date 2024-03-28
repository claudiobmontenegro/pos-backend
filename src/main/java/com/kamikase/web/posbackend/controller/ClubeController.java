package com.kamikase.web.posbackend.controller;

import com.kamikase.web.posbackend.client.CnpjClient;
import com.kamikase.web.posbackend.model.ApiDTO.CnpjResponseDTO;
import com.kamikase.web.posbackend.model.Clube;
import com.kamikase.web.posbackend.model.dto.ClubeDTO;
import com.kamikase.web.posbackend.service.ClubeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clube")
public class ClubeController {
    @Autowired
    ClubeService clubeService;

    @Autowired
    CnpjClient cnpjClient;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@Valid @RequestBody ClubeDTO clubeDTO){
        clubeService.create(clubeDTO);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void update(Clube clube){
        clubeService.update(clube);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Clube> findAll(){
        return clubeService.findAll();
    }

//    @GetMapping("/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public Optional<Clube> findById(@PathVariable Integer id){
//        return clubeService.findByid(id);
//    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable Integer id){
        clubeService.deleteById(id);
    }

    @GetMapping("/{cnpj}")
    @ResponseStatus(HttpStatus.OK)
    public CnpjResponseDTO findCnpj(@PathVariable String cnpj) {
        CnpjResponseDTO cnpjResponseDTO = cnpjClient.findCnpj(cnpj);
        return cnpjResponseDTO;
    }


    @GetMapping("/{nome}")
    @ResponseStatus(HttpStatus.OK)
    public List<Clube> findByNome(@PathVariable String nome){
        return clubeService.findByNomeOrderByNomeAsc(nome);
    }
}
