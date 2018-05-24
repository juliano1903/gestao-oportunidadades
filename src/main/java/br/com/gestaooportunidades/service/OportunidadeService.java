package br.com.gestaooportunidades.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	
	@Transactional
	public void apovaOportunidade(Long idOportunidade) {
		oportunidadeRepository.udateDataAprovacao(idOportunidade, new Date());
	}

	@Transactional
	public void reprovaOportunidade(Long idOportunidade) {
		oportunidadeRepository.udateDataReprovacao(idOportunidade, new Date());
	}
}
