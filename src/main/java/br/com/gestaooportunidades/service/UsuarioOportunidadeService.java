package br.com.gestaooportunidades.service;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import br.com.gestaooportunidades.model.Oportunidade;
import br.com.gestaooportunidades.model.Usuario;
import br.com.gestaooportunidades.model.UsuarioOportunidade;
import br.com.gestaooportunidades.model.UsuarioSession;
import br.com.gestaooportunidades.repository.UsuarioOportunidadeRepository; 

@Service
public class UsuarioOportunidadeService {
	
	@Autowired
	private UsuarioSession usuarioSession;

	@Autowired
	private UsuarioOportunidadeRepository usuarioOportunidadeRepository;
	
	public UsuarioOportunidade cadastrarSeOportunidade(Long idOportunidade) {
		UsuarioOportunidade usuarioOportunidade = new UsuarioOportunidade()
				.builder()
				.usuario(usuarioSession.getUsuario())
				.oportunidade(new Oportunidade()
								.builder()
								.idOportunidade(idOportunidade)
								.build())
				.build();
		
		return usuarioOportunidadeRepository.save(usuarioOportunidade);
	}

	public Iterable<UsuarioOportunidade> findAllByIdUsuario() {
		return usuarioOportunidadeRepository.findAllByIdUsuario(usuarioSession.getUsuario().getIdUsuario());		
	}

	public Iterable<Oportunidade> consultaCandidatura(Iterable<Oportunidade> oportunidades) {
		Usuario usuarioLogado = usuarioSession.getUsuario();
		for (Oportunidade oportunidade: oportunidades) {
			oportunidade.setCadidatoOportunidade(usuarioOportunidadeRepository
					.findByIdUsuarioAndIdOportunidade(usuarioLogado.getIdUsuario(), oportunidade.getIdOportunidade()).iterator().hasNext());
		}
		return oportunidades;
	}

	public Iterable<UsuarioOportunidade> consultaCandidatura(Long idOportunidade) {
		return usuarioOportunidadeRepository
		.findByIdOportunidade(idOportunidade);
	}

	@Transactional
	public void cancelarCandidatura(Long idUsuarioOportunidade) {
		usuarioOportunidadeRepository.udateDataCancelamentoByIdUsuarioOportunidade(idUsuarioOportunidade, new Date());
	}

	public void deleteByIdOportunidade(Long idOportunidade) {
		usuarioOportunidadeRepository.deleteByOportunidade(new Oportunidade().builder().idOportunidade(idOportunidade).build());
	}
	
	@Modifying
	public void udateDataCancelamentoByIdOportunidade(Long idOportunidade, Date dataCancelamento) {
		usuarioOportunidadeRepository.udateDataCancelamentoByIdOportunidade(idOportunidade, dataCancelamento);
	}
}
