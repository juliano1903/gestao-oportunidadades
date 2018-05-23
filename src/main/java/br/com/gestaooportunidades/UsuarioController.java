package br.com.gestaooportunidades;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.gestaooportunidades.model.Usuario;
import br.com.gestaooportunidades.service.UsuarioService;

@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping("salvar")
	public String salvar(@RequestParam("nome") String nome,
							@RequestParam("cpf") String cpf,
							@RequestParam("email") String email,
							@RequestParam("senha") String senha) {
		
		Usuario usuario = usuarioService.findByEmail(email);
		
		if(usuario == null) {
			usuarioService.save(new Usuario().builder()
					.nome(nome)
					.cpf(cpf)
					.email(email)
					.senha(senha)
					.build());
		} else {
			usuarioService.setUsuarioSessao(usuario);
		}
		
		return "index";
	}
	
	@RequestMapping("login")
	public String login(@RequestParam("email") String email,
						@RequestParam("senha") String senha) {
		
		if(usuarioService.logar(email, senha)) {
			return "redirect:index";
		}
		return "redirect:/";
	}
	
	@RequestMapping("/403")
	public String error403() {
		return "403";
	}
}
