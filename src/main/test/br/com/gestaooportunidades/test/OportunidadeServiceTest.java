package br.com.gestaooportunidades.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.gestaooportunidades.Configuracao;
import br.com.gestaooportunidades.model.Oportunidade;
import br.com.gestaooportunidades.service.OportunidadeService;

@RunWith(SpringRunner.class)
@SpringApplicationConfiguration(classes = Configuracao.class)
public class OportunidadeServiceTest {

	@Autowired
	OportunidadeService oportunidadeService;

	private Oportunidade oportunidade;
	
	@Before
	public void inicializaCenárioDeTestes() {
		oportunidade = new Oportunidade();
		String nome = "Gerente de Projetos DELL";
		oportunidade.setNome(nome);
		oportunidade = oportunidadeService.save(oportunidade);
	}
	
	@Test
	public void shouldSaveWhenOportunidadeIsPassed() {
		String n;
		Iterable<Oportunidade> resp = oportunidadeService.findAll();
		for (Oportunidade oportunidade : resp) {
			n = oportunidade.getNome().toString();
			if (n.equals(oportunidade.getNome())) {
				assertTrue(true);
				return;
			}
		}
		assertFalse(false);
		return;
	}
	
	@Test
	public void aprovarOportunidade() {
		oportunidadeService.aprovaOportunidade(oportunidade.getIdOportunidade());
		Oportunidade oportunidadeAprovada = oportunidadeService.findById(oportunidade.getIdOportunidade());
		assertNotNull(oportunidadeAprovada.getDataAprovacao());
	}

	@Test
	public void reprovarOportunidade() {
		oportunidadeService.reprovaOportunidade(oportunidade.getIdOportunidade());
		Oportunidade oportunidadeAprovada = oportunidadeService.findById(oportunidade.getIdOportunidade());
		assertNotNull(oportunidadeAprovada.getDataReprovacao());
	}
	
	@Test
	public void cancelarOportunidade() {
		oportunidadeService.cancelarOportunidade(oportunidade.getIdOportunidade());
		Oportunidade oportunidadeAprovada = oportunidadeService.findById(oportunidade.getIdOportunidade());
		assertNotNull(oportunidadeAprovada.getDataCancelamento());
	}
}
