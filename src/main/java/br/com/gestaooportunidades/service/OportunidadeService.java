package br.com.gestaooportunidades.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.gestaooportunidades.model.Empresa;
import br.com.gestaooportunidades.model.Oportunidade;
import br.com.gestaooportunidades.repository.OportunidadeRepository; 

@Service
public class OportunidadeService {

	@Autowired
	private OportunidadeRepository oportunidadeRepository;
	
	@Autowired
	private UsuarioOportunidadeService usuarioOportunidadeService;
	
	public void save (Oportunidade oportunidade) {
		oportunidadeRepository.save(oportunidade);
	}

	public Iterable<Oportunidade> findAll() {
		return oportunidadeRepository.findAll();
	}

	public Iterable<Oportunidade> findAllDisponiveis() {
		return oportunidadeRepository.findAllDisponiveis();
	}
	
	@Transactional
	public void apovaOportunidade(Long idOportunidade) {
		oportunidadeRepository.udateDataAprovacao(idOportunidade, new Date());
	}

	@Transactional
	public void reprovaOportunidade(Long idOportunidade) {
		oportunidadeRepository.udateDataReprovacao(idOportunidade, new Date());
	}

	@Transactional
	public void cancelarOportunidade(Long idOportunidade) {
		usuarioOportunidadeService.udateDataCancelamentoByIdOportunidade(idOportunidade, new Date());
		oportunidadeRepository.udateDataCancelamento(idOportunidade, new Date());
	}

	public Iterable<Oportunidade> findByIdEmpresa(Long idEmpresa) {
		return oportunidadeRepository.findByEmpresa(new Empresa().builder().idEmpresa(idEmpresa).build());
	}
}
