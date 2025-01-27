package com.accenture.consumo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.consumo.interfaces.CepService;
import com.accenture.consumo.model.Endereco;
import com.accenture.consumo.repository.EnderecoRepository;

@RestController
public class CepRestController {

    @Autowired
    private CepService cepService;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @PostMapping("/{cep}")
    public ResponseEntity<Endereco> postCep(@PathVariable String cep) {
        Endereco endereco = cepService.buscaEnderecoPorCep(cep);

        if (endereco != null) {
            // Salvar no banco de dados
            enderecoRepository.save(endereco);
            return ResponseEntity.ok().body(endereco);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
