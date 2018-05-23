package br.com.leilaoeletronico.service;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Iterables;

import br.com.leilaoeletronico.model.Lance;
import br.com.leilaoeletronico.model.Leilao;
import br.com.leilaoeletronico.repository.LanceRepository;

@Service
public class LanceService {
	
	@Autowired
	public LanceRepository lanceRepository;
		
	public void save(Lance lance) {
		lanceRepository.save(lance);
	}

	public Iterable<Lance> findAll() {
		return lanceRepository.findAll();
	}
	
	public Iterable<Lance> findByIdLeilao(Leilao leilao) {
		return lanceRepository.findByIdLeilao(leilao.getIdLeilao());
	}

	public Lance findLanceVencedor(Leilao leilao) {
		Iterable<Lance> lances = lanceRepository.findByIdLeilao(leilao.getIdLeilao());
		
	    final Comparator<Lance> valorComparator = (p1, p2) -> Long.compare( p1.getValor(), p2.getValor());

	    List<Lance> lancesList;

	    if(leilao.getNaturezaLeilao().getIdNaturezaLeilao() == 1) {
	    	lancesList = StreamSupport.stream(lances.spliterator(), false)
	    			.filter(p -> p.getDataHora().getTime() < leilao.getDataFim().getTime()
	    					&& p.getValor() > leilao.getValor())
	    			.collect(Collectors.toList());
			
		} else {
	    	lancesList = StreamSupport.stream(lances.spliterator(), false)
	    			.filter(p -> p.getDataHora().getTime() < leilao.getDataFim().getTime()
	    					&& p.getValor() < leilao.getValor())
	    			.collect(Collectors.toList());
		}

	    try {
	    	return StreamSupport.stream(lancesList.spliterator(), false)
	    			.max(valorComparator).get();
	    } catch (Exception e) {
			return null;
		}
	}
}
