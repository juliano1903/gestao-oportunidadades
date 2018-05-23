package br.com.leilaoeletronico;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.leilaoeletronico.model.Lance;
import br.com.leilaoeletronico.model.Leilao;
import br.com.leilaoeletronico.service.LanceService;
import br.com.leilaoeletronico.service.LeilaoService;

@RestController
public class LanceApiRestController {
	
	@Autowired
	private LanceService lanceService;
	
	@Autowired
	private LeilaoService leilaoService;

    @RequestMapping(value = "lance/{idLeilao}", method = RequestMethod.GET, produces = "application/json")
    public List<Lance> getLances(@PathVariable Long idLeilao) {
    	Iterable<Lance> lances = lanceService.findByIdLeilao(new Leilao().builder().idLeilao(idLeilao).build());
    	List<Lance> retorno = new ArrayList<Lance>();
    	for (Lance lance : lances) {
        	retorno.add(new Lance().builder().valorString(lance.getValorString()).dataHora(lance.getDataHora()).build());    		
    	}
 
    	return retorno;
    }
    
    @RequestMapping(value = "leilao/informacoes/{idLeilao}", method = RequestMethod.GET, produces = "application/json")
    public Leilao getInformacoes(@PathVariable Long idLeilao) {
    	
    	Leilao leilao = leilaoService.findByIdLeilao(idLeilao);
    	leilao.setFinalizado(leilaoService.isFinalizado(leilao));
    	
    	Lance lanceVencedor = lanceService.findLanceVencedor(leilao);
    			
    	return new Leilao().builder()
    			.dataFim(leilao.getDataFim())
    			.dataInicio(leilao.getDataInicio())
    			.lanceVencedor(lanceVencedor != null ? lanceVencedor.getValorString() : "")
    			.naturezaLeilao(leilao.getNaturezaLeilao())
    			.valorString(leilao.isFinalizado() || leilao.getTipoLance().idTipoLance == 2 ? leilao.getValorString() : "")
    			.build();
    }
}
