package br.com.gestaooportunidades.service;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	public void cadastrarSeOportunidade(Long idOportunidade) {
		UsuarioOportunidade usuarioOportunidade = new UsuarioOportunidade()
				.builder()
				.usuario(usuarioSession.getUsuario())
				.oportunidade(new Oportunidade()
								.builder()
								.idOportunidade(idOportunidade)
								.build())
				.build();
		
		usuarioOportunidadeRepository.save(usuarioOportunidade);
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

	public void cancelarCandidatura(Long idUsuarioOportunidade) {
		usuarioOportunidadeRepository.delete(idUsuarioOportunidade);
	}
}
