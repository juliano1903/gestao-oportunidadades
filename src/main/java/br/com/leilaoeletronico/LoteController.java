package br.com.leilaoeletronico;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.leilaoeletronico.model.CategoriaItem;
import br.com.leilaoeletronico.model.Item;
import br.com.leilaoeletronico.model.Lote;
import br.com.leilaoeletronico.service.CategoriaItemService;
import br.com.leilaoeletronico.service.ItemService;
import br.com.leilaoeletronico.service.LeilaoService;
import br.com.leilaoeletronico.service.LoteService;

@Controller
public class LoteController {
	
//	@Autowired
//	private SessionInfo sessionInfo;
//	
	@Autowired
	private CategoriaItemService categoriaItemService;
	
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private LoteService loteService;
	
	@RequestMapping("crialote")
	public String criarLote(Model model) {
		categoriaItemService.findAll();
		model.addAttribute("categorias", categoriaItemService.findAll());
		model.addAttribute("itens", itemService.findAll());
		return "crialote";
	}
	
	@RequestMapping("criaitem")
	public String criarItem(@RequestParam("nome") String nome,
							@RequestParam("descricao") String descricao,
							@RequestParam("idCategoria") Long idCategoria) {
		
		itemService.save(new Item().builder()
							.nome(nome)
							.descricao(descricao)
							.categoria(new CategoriaItem().builder().idCategoriaItem(idCategoria).build())
							.build());
		
		return "redirect:crialote";
		
	}

	@RequestMapping("salvarlote")
	public String salvarLote(@RequestParam("idItem") List<Long> idsItens, 
								@RequestParam("nome") String nome) {
		
		Lote lote = loteService.save(new Lote().builder().descricao(nome).build());
		lote.setItens(new ArrayList<Item>());
		
		for(Long idItem : idsItens) {
			lote.getItens().add(itemService.findByIdItem(idItem));
		}
		
		loteService.save(lote);
		
		return "redirect:crialote";
		
	}
}
