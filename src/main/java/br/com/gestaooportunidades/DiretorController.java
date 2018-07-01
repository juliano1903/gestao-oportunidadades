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
import br.com.gestaooportunidades.service.EmpresaService;
import br.com.gestaooportunidades.service.OportunidadeService;
import br.com.gestaooportunidades.service.UsuarioOportunidadeService;

@Controller
@RequestMapping("/diretor")
public class DiretorController {

	@Autowired
	private EmpresaService empresaService;
	
	@Autowired
	private OportunidadeService oportunidadeService;
	
	@Autowired
	private UsuarioOportunidadeService usuarioOportunidadeService;
	
	@RequestMapping("consultaroportunidades")
	public String consultaOportunidade(Model model, HttpSession session) {
		Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
		Iterable<Oportunidade> oportunidades = oportunidadeService.findAll();
		model.addAttribute("oportunidades", oportunidades);
		return "diretor/consultaroportunidades";
	}
	
	@RequestMapping("cancelaroportunidade")
	public String cancelarOportunidade(@RequestParam("idOportunidade") Long idOportunidade, Model model) {
		oportunidadeService.cancelarOportunidade(idOportunidade);
		return "redirect:consultaroportunidades";
	}
	
	@RequestMapping("aprovaoportunidade")
	public String aprovaOportunidade(@RequestParam("idOportunidade") Long idOportunidade, Model model) {
		oportunidadeService.apovaOportunidade(idOportunidade);
		return "redirect:consultaroportunidades";
	}

	@RequestMapping("reprovaroportunidade")
	public String reprovaOportunidade(@RequestParam("idOportunidade") Long idOportunidade, Model model) {
		oportunidadeService.reprovaOportunidade(idOportunidade);
		return "redirect:consultaroportunidades";
	}
	
	@RequestMapping("selecionarempresa")
	public String selecionarEmpresa(Model model) {
		empresaService.findAll();
		model.addAttribute("empresas", empresaService.findAll());
		return "secretaria/selecionarempresa";
	}
	
	@RequestMapping("historicooportunidades")
	public String historicoOportunidade(@RequestParam("idEmpresa") Long idEmpresa, Model model) {
		Iterable<Oportunidade> oportunidades = oportunidadeService.findByIdEmpresa(idEmpresa);
		model.addAttribute("oportunidades", oportunidades);
		return "diretor/historicooportunidades";
	}
	
	@RequestMapping("consultarcandidatos")
	public String consultarCandidatos(@RequestParam("idOportunidade") Long idOportunidade, Model model) {
		Iterable<UsuarioOportunidade> candidatosOportunidade = usuarioOportunidadeService.consultaCandidatura(idOportunidade);
		model.addAttribute("candidatosOportunidade", candidatosOportunidade);
		return "secretaria/consultarcandidatos";
	}
}
