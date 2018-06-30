package br.com.gestaooportunidades;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.gestaooportunidades.model.Oportunidade;
import br.com.gestaooportunidades.model.Usuario;
import br.com.gestaooportunidades.model.UsuarioOportunidade;
import br.com.gestaooportunidades.service.OportunidadeService;
import br.com.gestaooportunidades.service.UsuarioOportunidadeService;

@Controller
@RequestMapping(value="/aluno")
public class AlunoController {

	@Autowired
	private OportunidadeService oportunidadeService;
	
	@Autowired
	private UsuarioOportunidadeService usuarioOportunidadeService; 
	
	@RequestMapping("candidatarse")
	public String candidatarSeOportunidade(@RequestParam("idOportunidade") Long idOportunidade, Model model) {
		usuarioOportunidadeService.cadastrarSeOportunidade(idOportunidade);
		return "redirect:consultaroportunidades";
	}
	
	@RequestMapping("consultaroportunidades")
	public String alunoConsultaOportunidade(Model model, HttpSession session) {
		Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
		Iterable<Oportunidade> oportunidades;
		
		if(usuario.getIdTipoUsuario().equals(new Long(1l))) {
			oportunidades = oportunidadeService.findAllDisponiveis();
			usuarioOportunidadeService.consultaCandidatura(oportunidades);
		} else {
			oportunidades = oportunidadeService.findAll();
		}
		
		model.addAttribute("oportunidades", oportunidades);
		return "aluno/consultaroportunidades";
	}
	
	@RequestMapping("consultarcandidaturas")
	public String consultarCandidaturas(Model model, HttpSession session) {
		Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
		Iterable<UsuarioOportunidade> oportunidades = usuarioOportunidadeService.findAllByIdUsuario();
		model.addAttribute("candidaturas", oportunidades);
		return "aluno/consultarcandidaturas";
	}
	
	@RequestMapping("cancelarcandidatura")
	public String cancelarCandidatura(@RequestParam("idOportunidade") Long idUsuarioOportunidade, Model model, HttpSession session) {
		Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
		usuarioOportunidadeService.cancelarCandidatura(idUsuarioOportunidade);
		return "redirect:consultarcandidaturas";
	}
}
