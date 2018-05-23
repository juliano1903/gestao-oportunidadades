package br.com.gestaooportunidades.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.gestaooportunidades.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

	public Usuario findByIdUsuario(Long idUsuario);

	public Usuario findByEmail(String email);
 
	@Query("select u from Usuario u where u.email = ?1 and u.senha = ?2")
	public Usuario findByEmailAndSenha(String email, String senha);

}
