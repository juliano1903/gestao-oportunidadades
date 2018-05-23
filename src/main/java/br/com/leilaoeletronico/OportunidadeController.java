package br.com.leilaoeletronico;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.leilaoeletronico.model.CategoriaItem;
import br.com.leilaoeletronico.model.Empresa;
import br.com.leilaoeletronico.model.Item;
import br.com.leilaoeletronico.model.Lance;
import br.com.leilaoeletronico.model.Leilao;
import br.com.leilaoeletronico.model.Lote;
import br.com.leilaoeletronico.model.NaturezaLeilao;
import br.com.leilaoeletronico.model.Oportunidade;
import br.com.leilaoeletronico.model.TipoLance;
import br.com.leilaoeletronico.model.UsuarioSession;
import br.com.leilaoeletronico.service.EmpresaService;
import br.com.leilaoeletronico.service.LanceService;
import br.com.leilaoeletronico.service.LeilaoService;
import br.com.leilaoeletronico.service.LoteService;
import br.com.leilaoeletronico.service.NaturezaLeilaoService;
import br.com.leilaoeletronico.service.OportunidadeService;

@Controller
public class OportunidadeController {
	
	@Autowired
	private UsuarioSession usuarioSession;
	
	@Autowired
	private EmpresaService empresaService;
	
	@Autowired
	private OportunidadeService oportunidadeService;
	
	@RequestMapping("/indexdfd")
	public String index(){
		return "index";
	}
	
	@RequestMapping("/dfdf")
	public String login(){
		return "login";
	}
	
	@RequestMapping("cadastrarempresa")
	public String criarLote(Model model) {
		return "cadastrarempresa";
	}
	
	@RequestMapping("salvarempresa")
	public String cadastrarEmpresa(@RequestParam("nome") String nome,
									@RequestParam("cnpj") String cnpj,
									@RequestParam("endereco") String endereco) {
		
		empresaService.save(new Empresa().builder()
							.nome(nome)
							.cnpj(cnpj)
							.endereco(endereco)
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
							@RequestParam("descricao") String descricao,
							@RequestParam("idEmpresa") Long idEmpresa) {
		
		oportunidadeService.save(new Oportunidade().builder()
							.valorString(valorString)
							.descricao(descricao)
							.empresa(new Empresa().builder().idEmpresa(idEmpresa).build())
							.build());
		
		return "redirect:cadastraroportunidade";
		
	}
	
//	@RequestMapping("/buscaleiloes")
//	public String buscaLeiloes(Model model){
//		Iterable<Leilao> leiloes = leilaoService.findAll();
//		
//    	for (Leilao leilao : leiloes) {
//    		leilao.setFinalizado(leilaoService.isFinalizado(leilao));
//    	}
//
//		model.addAttribute("leiloes", leiloes);
//		return "buscaLeiloes";
//	}
//	
//	@RequestMapping("crialeilao")
//	public String criaLeilao(Model model){
//		model.addAttribute("naturezas", naturezaLeilaoService.findAll());
//		model.addAttribute("lotes", loteService.findAll());
//		return "crialeilao";
//	}
//	
//	@RequestMapping("crialeilaoconfirmar")
//	public String criaLeilaoConfirmar(@RequestParam("naturezaLeilao") Long naturezaLeilao,
//										@RequestParam("tipoLance") Long tipoLance,
//										@RequestParam("dataInicio") Date dataInicio,
//										@RequestParam("dataFim") Date dataFim,
//										@RequestParam("idLote") Long idLote,
//										@RequestParam("valorString") String valorString){
//		
//		leilaoService.save(new Leilao().builder()
//		.dataFim(dataFim)
//		.dataInicio(dataInicio)
//		.naturezaLeilao(new NaturezaLeilao().builder().idNaturezaLeilao(naturezaLeilao).build())
//		.tipoLance(new TipoLance().builder().idTipoLance(tipoLance).build())
//		.lote(new Lote().builder().idLote(idLote).build())
//		.valorString(valorString)
//		.valor(Long.parseLong(valorString.replace(",", "").replace(".", "")))
//		.usuario(usuarioSession.getUsuario())
//		.build());
//		
//		return "redirect:index";
//	}
//	
//	@RequestMapping("efetuarLance")
//	public String efetuarLance(@RequestParam("valorString") String valorString,
//								@RequestParam("idLeilao") Long idLeilao){
//		lanceService.save(new Lance().builder()
//				.valorString(valorString)
//				.valor(Long.parseLong(valorString.replace(",", "").replace(".", "")))
//				.usuario(usuarioSession.getUsuario())
//				.dataHora(new Date())
//				.leilao(new Leilao().builder().idLeilao(idLeilao).build())
//				.build());
//		return "redirect:buscaleiloes";
//	}
}
