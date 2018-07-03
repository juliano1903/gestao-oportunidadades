package br.com.gestaooportunidades.test;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.gestaooportunidades.Configuracao;
import br.com.gestaooportunidades.model.Usuario;
import br.com.gestaooportunidades.model.UsuarioOportunidade;
import br.com.gestaooportunidades.service.OportunidadeService;
import br.com.gestaooportunidades.service.UsuarioOportunidadeService;
import br.com.gestaooportunidades.service.UsuarioService;

@RunWith(SpringRunner.class)
@SpringApplicationConfiguration(classes = Configuracao.class)
public class UsuarioOportunidadeServiceTest {

	@Autowired
	private OportunidadeService oportunidadeService;

	@Autowired
	private UsuarioOportunidadeService usuarioOportunidadeService;

	@Autowired
	private UsuarioService usuarioService;

	private UsuarioOportunidade usuarioOportunidade;

	private Usuario usuario;
	
	@Before
	public void inicializarCenarioDeTeste() {
		usuario = usuarioService.logar("1", "1");
	}
	
	@Test
	public void cadastrarSeOportunidade () {
		usuarioOportunidade = usuarioOportunidadeService.cadastrarSeOportunidade(1l);
		assertTrue(usuario.getIdUsuario().equals(usuarioOportunidade.getUsuario().getIdUsuario()));
	}
}
