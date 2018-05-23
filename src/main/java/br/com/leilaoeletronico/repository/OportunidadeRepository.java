package br.com.leilaoeletronico.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.leilaoeletronico.model.Oportunidade;

public interface OportunidadeRepository extends JpaRepository<Oportunidade, Long>{}
