package br.com.leilaoeletronico.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.leilaoeletronico.model.Lance;
import br.com.leilaoeletronico.model.Leilao;

public interface LanceRepository extends CrudRepository<Lance, Long>  {

	@Query("select l from Lance l where l.leilao.idLeilao = ?1")
	Iterable<Lance> findByIdLeilao(Long idLeilao);

}
