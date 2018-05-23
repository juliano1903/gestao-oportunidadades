package br.com.gestaooportunidades.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gestaooportunidades.model.Oportunidade;
import br.com.gestaooportunidades.repository.OportunidadeRepository; 

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
