package br.com.leilaoeletronico;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.leilaoeletronico.model.Lance;
import br.com.leilaoeletronico.model.Leilao;
import br.com.leilaoeletronico.model.Lote;
import br.com.leilaoeletronico.model.NaturezaLeilao;
import br.com.leilaoeletronico.model.TipoLance;
import br.com.leilaoeletronico.model.UsuarioSession;
import br.com.leilaoeletronico.service.LanceService;
import br.com.leilaoeletronico.service.LeilaoService;
import br.com.leilaoeletronico.service.LoteService;
import br.com.leilaoeletronico.service.NaturezaLeilaoService;

@Controller
public class LeilaoController {
	
	@Autowired
	private UsuarioSession usuarioSession;
	
	@Autowired
	private NaturezaLeilaoService naturezaLeilaoService;
	
	@Autowired
	private LeilaoService leilaoService; 
	
	@Autowired 
	private LoteService loteService;
	
	@Autowired 
	private LanceService lanceService;
	
	@RequestMapping("/index")
	public String index(){
		return "index";
	}
	
	@RequestMapping("/")
	public String login(){
		return "login";
	}
	
	@RequestMapping("/buscaleiloes")
	public String buscaLeiloes(Model model){
		Iterable<Leilao> leiloes = leilaoService.findAll();
		
    	for (Leilao leilao : leiloes) {
    		leilao.setFinalizado(leilaoService.isFinalizado(leilao));
    	}

		model.addAttribute("leiloes", leiloes);
		return "buscaLeiloes";
	}
	
	@RequestMapping("crialeilao")
	public String criaLeilao(Model model){
		model.addAttribute("naturezas", naturezaLeilaoService.findAll());
		model.addAttribute("lotes", loteService.findAll());
		return "crialeilao";
	}
	
	@RequestMapping("crialeilaoconfirmar")
	public String criaLeilaoConfirmar(@RequestParam("naturezaLeilao") Long naturezaLeilao,
										@RequestParam("tipoLance") Long tipoLance,
										@RequestParam("dataInicio") Date dataInicio,
										@RequestParam("dataFim") Date dataFim,
										@RequestParam("idLote") Long idLote,
										@RequestParam("valorString") String valorString){
		
		leilaoService.save(new Leilao().builder()
		.dataFim(dataFim)
		.dataInicio(dataInicio)
		.naturezaLeilao(new NaturezaLeilao().builder().idNaturezaLeilao(naturezaLeilao).build())
		.tipoLance(new TipoLance().builder().idTipoLance(tipoLance).build())
		.lote(new Lote().builder().idLote(idLote).build())
		.valorString(valorString)
		.valor(Long.parseLong(valorString.replace(",", "").replace(".", "")))
		.usuario(usuarioSession.getUsuario())
		.build());
		
		return "redirect:index";
	}
	
	@RequestMapping("efetuarLance")
	public String efetuarLance(@RequestParam("valorString") String valorString,
								@RequestParam("idLeilao") Long idLeilao){
		lanceService.save(new Lance().builder()
				.valorString(valorString)
				.valor(Long.parseLong(valorString.replace(",", "").replace(".", "")))
				.usuario(usuarioSession.getUsuario())
				.dataHora(new Date())
				.leilao(new Leilao().builder().idLeilao(idLeilao).build())
				.build());
		return "redirect:buscaleiloes";
	}
}
