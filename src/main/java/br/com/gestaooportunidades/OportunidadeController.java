package br.com.gestaooportunidades;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.gestaooportunidades.model.Empresa;
import br.com.gestaooportunidades.model.Oportunidade;
import br.com.gestaooportunidades.model.UsuarioSession;
import br.com.gestaooportunidades.service.EmpresaService;
import br.com.gestaooportunidades.service.OportunidadeService;

@Controller
public class OportunidadeController {

	@Autowired
	private UsuarioSession usuarioSession;

	@Autowired
	private EmpresaService empresaService;

	@Autowired
	private OportunidadeService oportunidadeService;

	@RequestMapping("/index")
	public String index() {
		return "index";
	}

	@RequestMapping("/")
	public String login() {
		return "login";
	}

	@RequestMapping("cadastrarempresa")
	public String criarLote(Model model) {
		return "cadastrarempresa";
	}

	@RequestMapping("salvarempresa")
	public String cadastrarEmpresa(@RequestParam("nome") String nome, @RequestParam("nomeFantasia") String nomeFantasia, @RequestParam("cnpj") String cnpj,
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
	public String cadastrarEmpresa(Model model) {
		empresaService.findAll();
		model.addAttribute("empresas", empresaService.findAll());
		return "cadastraroportunidade";
	}

	@RequestMapping("salvaroportunidade")
	public String criarItem(@RequestParam("valorString") String valorString,
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

	@RequestMapping("consultaroportunidades")
	public String buscaLeiloes(Model model) {
		Iterable<Oportunidade> oportunidades = oportunidadeService.findAll();
		model.addAttribute("oportunidades", oportunidades);
		return "consultaroportunidades";
	}
}
