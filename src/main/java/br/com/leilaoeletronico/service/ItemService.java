package br.com.leilaoeletronico.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.leilaoeletronico.model.Item;
import br.com.leilaoeletronico.repository.ItemRepository;

@Service
public class ItemService {

	@Autowired
	private ItemRepository itemrepository;
	
	public void save(Item item) {
		itemrepository.save(item);
	}
	
	public Iterable<Item> findAll() {
		return itemrepository.findAll();
	}
	
	public Item findByIdItem(Long idItem) {
		return itemrepository.findByIdItem(idItem);
	}
}
