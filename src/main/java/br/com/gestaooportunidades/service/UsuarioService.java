package br.com.gestaooportunidades.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gestaooportunidades.model.Usuario;
import br.com.gestaooportunidades.model.UsuarioSession;
import br.com.gestaooportunidades.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioSession usuarioSession;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public void save(Usuario usuario) {
		usuarioRepository.save(usuario);
	}
	
	public Usuario findByIdUsuario(Long idUsuario) {
		return usuarioRepository.findByIdUsuario(idUsuario);
	}
	
	public Usuario findByEmail(String email) {
		return usuarioRepository.findByEmail(email);
	}

	public Usuario logar(String email, String senha) {
		Usuario usuario = usuarioRepository.findByEmailAndSenha(email, senha);
		if(usuario != null) {
			usuarioSession.setUsuario(usuario);
		}
		return usuario;
	}
	
	public void setUsuarioSessao (Usuario usuario) {
		usuarioSession.setUsuario(usuario);
	}
	
	public UsuarioSession getUsuarioSessao() {
		return usuarioSession;
	}
}
