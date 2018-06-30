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
import br.com.gestaooportunidades.service.EmpresaService;
import br.com.gestaooportunidades.service.OportunidadeService;
import br.com.gestaooportunidades.service.UsuarioOportunidadeService;

@Controller
public class OportunidadeController {

	@Autowired
	private EmpresaService empresaService;

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
	
	@RequestMapping("cadastrarempresa")
	public String cadastrarEmpresa(Model model) {
		model.addAttribute("empresas", empresaService.findAll());
		return "cadastrarempresa";
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

	@RequestMapping("cadastraroportunidade")
	public String cadastrarOportunidade(Model model) {
		empresaService.findAll();
		model.addAttribute("empresas", empresaService.findAll());
		return "cadastraroportunidade";
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

	@RequestMapping("empresaconsultaroportunidades")
	public String empresaConsultaOportunidade(Model model, HttpSession session) {
		Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
		Iterable<Oportunidade> oportunidades;
		
		if(usuario.getIdTipoUsuario().equals(new Long(1l))) {
			oportunidades = oportunidadeService.findAllDisponiveis();
			usuarioOportunidadeService.consultaCandidatura(oportunidades);
		} else {
			oportunidades = oportunidadeService.findAll();
		}
		
		model.addAttribute("oportunidades", oportunidades);
		return "consultaroportunidades";
	}
}
