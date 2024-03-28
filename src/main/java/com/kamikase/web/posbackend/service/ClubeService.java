package com.kamikase.web.posbackend.service;

import com.kamikase.web.posbackend.model.Clube;
import com.kamikase.web.posbackend.model.dto.ClubeDTO;
import com.kamikase.web.posbackend.repository.ClubeRepository;
import com.kamikase.web.posbackend.validator.ClubeValidator;
import jakarta.validation.Constraint;
import jakarta.validation.ConstraintViolation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.validation.Validator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

@Service
public class ClubeService {

    @Autowired
    ClubeRepository clubeRepository;


//    @Autowired
//    public ClubeService(ClubeRepository clubeRepository, Validator validator){
//        this.clubeRepository = clubeRepository;
//        this.validator = validator;
//    };
//
//    private final ClubeRepository clubeRepository;
//    private final Validator validator;


    public List<Clube> findAll(){
        return clubeRepository.findAll();
    }

    public Optional<Clube> findByid(Integer id){
        return clubeRepository.findById(id);
    }

    public Clube create(ClubeDTO clubeDTO){
        Clube clube = new Clube();


        clube.setNome(clubeDTO.getNome());
        clube.setEstado(clubeDTO.getEstado());
        clube.setEmail(clubeDTO.getEmail());
        clube.setCpnj(clubeDTO.getCnpj());
        clube.setDataCriacao(clubeDTO.getDataCriacao());

        return clubeRepository.save(clube);
    }

    public Clube update(Clube clube){
        if (Objects.isNull(clube.getId())){
            throw new RuntimeException();
        }
        return clubeRepository.save(clube);
    }

    public List<Clube> findByNomeOrderByNomeAsc(String nome) {
        return clubeRepository.findByNomeContainingIgnoreCaseOrderByNomeAsc(nome);
    }

    public void deleteById(Integer id){
        clubeRepository.deleteById(id);
    }
}
