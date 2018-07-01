package br.com.gestaooportunidades;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.gestaooportunidades.service.OportunidadeService;
import br.com.gestaooportunidades.service.UsuarioOportunidadeService;

@Controller
public class OportunidadeController {

	@Autowired
	private OportunidadeService oportunidadeService;
	
	@Autowired
	private UsuarioOportunidadeService usuarioOportunidadeService; 

	@RequestMapping("/index")
	public String index() {
		return "index";
	}

	@RequestMapping("/")
	public String login() {
		return "login";
	}
}
