package br.com.leilaoeletronico.service;

import java.util.Date;

import org.hibernate.secure.spi.PermissibleAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.leilaoeletronico.model.Leilao;
import br.com.leilaoeletronico.repository.LeilaoRepository;

@Service
public class LeilaoService {

	@Autowired
	private LeilaoRepository leilaoRepository;
	
	public void save (Leilao leilao) {
		leilaoRepository.save(leilao);
	}

	public Iterable<Leilao> findAll() {
		return leilaoRepository.findAll();
	}

	public Leilao findByIdLeilao(Long idLeilao) {
		return leilaoRepository.findByIdLeilao(idLeilao);
	}
	
	public boolean isFinalizado(Leilao leilao) {
		return leilao.getDataFim().getTime() < new Date().getTime();
	}
}
