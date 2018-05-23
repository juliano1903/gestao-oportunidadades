package br.com.leilaoeletronico.service;

import java.util.Date;

import org.hibernate.secure.spi.PermissibleAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.leilaoeletronico.model.Empresa;
import br.com.leilaoeletronico.model.Leilao;
import br.com.leilaoeletronico.repository.EmpresaRepository;
import br.com.leilaoeletronico.repository.LeilaoRepository;

@Service
public class EmpresaService {

	@Autowired
	private EmpresaRepository empresaRepository;
	
	public void save (Empresa empresa) {
		empresaRepository.save(empresa);
	}

	public Iterable<Empresa> findAll() {
		return empresaRepository.findAll();
	}
}
