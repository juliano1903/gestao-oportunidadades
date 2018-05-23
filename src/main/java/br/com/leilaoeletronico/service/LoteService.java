package br.com.leilaoeletronico.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.leilaoeletronico.model.Lote;
import br.com.leilaoeletronico.repository.LoteRepository;

@Service
public class LoteService {

	@Autowired
	private LoteRepository loteRepository;
	
	public Lote save(Lote lote) {
		return loteRepository.save(lote);
	}
	
	public Iterable<Lote> findAll() {
		return loteRepository.findAll();
	}
}
