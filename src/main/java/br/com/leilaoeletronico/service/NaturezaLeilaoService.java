package br.com.leilaoeletronico.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.leilaoeletronico.model.NaturezaLeilao;
import br.com.leilaoeletronico.repository.NaturezaLeilaoRepository;

@Service
public class NaturezaLeilaoService {

	@Autowired
	private NaturezaLeilaoRepository naturezaLeilaoRepository;
	
	public Iterable<NaturezaLeilao> findAll () {
		return naturezaLeilaoRepository.findAll();
	}
}
