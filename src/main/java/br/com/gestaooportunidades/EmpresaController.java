package br.com.gestaooportunidades;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.gestaooportunidades.model.Empresa;
import br.com.gestaooportunidades.model.Oportunidade;
import br.com.gestaooportunidades.model.Usuario;
import br.com.gestaooportunidades.model.UsuarioOportunidade;
import br.com.gestaooportunidades.service.EmpresaService;
import br.com.gestaooportunidades.service.OportunidadeService;
import br.com.gestaooportunidades.service.UsuarioOportunidadeService;

@Controller
@RequestMapping("/empresa")
public class EmpresaController {


	@Autowired
	private EmpresaService empresaService;
	
	@Autowired
	private OportunidadeService oportunidadeService;
	
	@Autowired
	private UsuarioOportunidadeService usuarioOportunidadeService; 
	
	@RequestMapping("cadastraroportunidade")
	public String cadastrarOportunidade(Model model) {
		empresaService.findAll();
		model.addAttribute("empresas", empresaService.findAll());
		return "empresa/cadastraroportunidade";
	}
	
	@RequestMapping("consultaroportunidades")
	public String empresaConsultaOportunidade(Model model, HttpSession session) {
		Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
		Iterable<Oportunidade> oportunidades = oportunidadeService.findAll();
		model.addAttribute("oportunidades", oportunidades);
		return "empresa/consultaroportunidades";
	}
	
	@RequestMapping("cancelaroportunidade")
	public String cancelarOportunidade(@RequestParam("idOportunidade") Long idOportunidade, Model model) {
		oportunidadeService.cancelarOportunidade(idOportunidade);
		return "redirect:consultaroportunidades";
	}
	
	@RequestMapping("salvaroportunidade")
	public String salvaOportunidade(@RequestParam("valorString") String valorString,
							@RequestParam("nome") String nome, 
							@RequestParam("descricao") String descricao, 
							@RequestParam("idEmpresa") Long idEmpresa) {
		oportunidadeService.save(new Oportunidade().builder()
													.valorString(valorString)
													.nome(nome)
													.descricao(descricao)
													.empresa(new Empresa().builder()
																			.idEmpresa(idEmpresa)
																			.build())
													.build());
		return "redirect:cadastraroportunidade";
	}
	
	@RequestMapping("consultarcandidatos")
	public String consultarCandidatos(@RequestParam("idOportunidade") Long idOportunidade, Model model) {
		Iterable<UsuarioOportunidade> candidatosOportunidade = usuarioOportunidadeService.consultaCandidatura(idOportunidade);
		model.addAttribute("candidatosOportunidade", candidatosOportunidade);
		return "empresa/consultarcandidatos";
	}
}
