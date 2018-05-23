package br.com.leilaoeletronico.service;

import java.util.Date;

import org.hibernate.secure.spi.PermissibleAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.leilaoeletronico.model.Leilao;
import br.com.leilaoeletronico.model.Oportunidade;
import br.com.leilaoeletronico.repository.LeilaoRepository;
import br.com.leilaoeletronico.repository.OportunidadeRepository;

@Service
public class OportunidadeService {

	@Autowired
	private OportunidadeRepository oportunidadeRepository;
	
	public void save (Oportunidade oportunidade) {
		oportunidadeRepository.save(oportunidade);
	}

	public Iterable<Oportunidade> findAll() {
		return oportunidadeRepository.findAll();
	}
}
