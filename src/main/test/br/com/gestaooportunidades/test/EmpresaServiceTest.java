package br.com.gestaooportunidades.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.gestaooportunidades.Configuracao;
import br.com.gestaooportunidades.model.Empresa;
import br.com.gestaooportunidades.repository.EmpresaRepository;
import br.com.gestaooportunidades.service.EmpresaService;

@RunWith(SpringRunner.class)
@SpringApplicationConfiguration(classes = Configuracao.class)
public class EmpresaServiceTest {
	
	@Autowired
	EmpresaService empresaServ;

	@Autowired
	EmpresaRepository empresaRep;
	
	private Empresa empresa;

	@org.junit.Before
	public void inicializaCenarioDeTeste() {
		empresa = new Empresa();
	}
	
	@Test
	public void shouldSaveWhenEmpresaIsPassed() {
		
		String nome			= "Fulano de Tal";
		String nomeFantasia	= "CiclanatoBeer";
		String endereco		= "Ramiro Barcelos 1670 ap 606";
		String cnpj			= "97.149.942/0001-87";
		
		empresa.setNome(nome);
		empresa.setNomeFantasia(nomeFantasia);
		empresa.setEndereco(endereco);
		empresa.setCnpj(cnpj);
		
		empresaServ.save(empresa);
		
		String n;
		Iterable<Empresa> resp = empresaServ.findAll();	
		for (Empresa empresa : resp) {
			n = empresa.getNome().toString();
			if(n.equals(nome)){
				assertTrue(true);
				return;
			}
		}		
		assertFalse(true);
		return;
	}	
}
