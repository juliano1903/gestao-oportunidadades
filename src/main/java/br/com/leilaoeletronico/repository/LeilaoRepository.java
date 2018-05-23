package br.com.leilaoeletronico.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.leilaoeletronico.model.Leilao;

public interface LeilaoRepository extends CrudRepository<Leilao, Long>{

	Leilao findByIdLeilao(Long idLeilao);

}
