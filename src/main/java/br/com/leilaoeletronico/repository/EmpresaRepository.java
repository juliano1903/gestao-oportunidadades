package br.com.leilaoeletronico.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.leilaoeletronico.model.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {}
