package br.com.leilaoeletronico.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.leilaoeletronico.model.Usuario;
import br.com.leilaoeletronico.model.UsuarioSession;
import br.com.leilaoeletronico.repository.UsuarioRepository;

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

	public boolean logar(String email, String senha) {
		usuarioSession.setUsuario(usuarioRepository.findByEmailAndSenha(email, senha));
		if(usuarioSession.getUsuario() == null) {
			return false;
		}
		return true;
	}
	
	public void setUsuarioSessao (Usuario usuario) {
		usuarioSession.setUsuario(usuario);
	}
}
