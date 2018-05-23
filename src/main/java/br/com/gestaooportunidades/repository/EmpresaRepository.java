package br.com.gestaooportunidades.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gestaooportunidades.model.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {}
