package br.com.leilaoeletronico.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.leilaoeletronico.model.Item;

public interface ItemRepository extends CrudRepository<Item, Long>{

	Item findByIdItem(Long id);
}
