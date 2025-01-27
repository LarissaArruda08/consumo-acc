package com.accenture.consumo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.accenture.consumo.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, String> {
}
