package br.com.gestaooportunidades.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gestaooportunidades.model.Oportunidade;

public interface OportunidadeRepository extends JpaRepository<Oportunidade, Long>{}
