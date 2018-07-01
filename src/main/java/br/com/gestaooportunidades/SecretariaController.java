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
@RequestMapping("/secretaria")
public class SecretariaController {

	@Autowired
	private EmpresaService empresaService;
	
	@Autowired
	private OportunidadeService oportunidadeService;
	
	@Autowired
	private UsuarioOportunidadeService usuarioOportunidadeService;
	
	@RequestMapping("cadastrarempresa")
	public String cadastrarEmpresa(Model model) {
		model.addAttribute("empresas", empresaService.findAll());
		return "secretaria/cadastrarempresa";
	}

	@RequestMapping("salvarempresa")
	public String salvarEmpresa(@RequestParam("nome") String nome, @RequestParam("nomeFantasia") String nomeFantasia, @RequestParam("cnpj") String cnpj,
			@RequestParam("endereco") String endereco) {
		empresaService.save(new Empresa().builder()
										.nome(nome)
										.cnpj(cnpj)
										.endereco(endereco)
										.nomeFantasia(nomeFantasia)
										.build());
		return "redirect:cadastrarempresa";
	}
	
	@RequestMapping("consultaroportunidades")
	public String consultaOportunidade(Model model, HttpSession session) {
		Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
		Iterable<Oportunidade> oportunidades = oportunidadeService.findAll();
		model.addAttribute("oportunidades", oportunidades);
		return "secretaria/consultaroportunidades";
	}
	
	@RequestMapping("cancelaroportunidade")
	public String cancelarOportunidade(@RequestParam("idOportunidade") Long idOportunidade, Model model) {
		oportunidadeService.cancelarOportunidade(idOportunidade);
		return "redirect:consultaroportunidades";
	}
	
	@RequestMapping("consultarcandidatos")
	public String consultarCandidatos(@RequestParam("idOportunidade") Long idOportunidade, Model model) {
		Iterable<UsuarioOportunidade> candidatosOportunidade = usuarioOportunidadeService.consultaCandidatura(idOportunidade);
		model.addAttribute("candidatosOportunidade", candidatosOportunidade);
		return "secretaria/consultarcandidatos";
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
		return "secretaria/historicooportunidades";
	}
}
