package br.com.leilaoeletronico.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.leilaoeletronico.model.CategoriaItem;
import br.com.leilaoeletronico.repository.CategoriaItemRepository;

@Service
public class CategoriaItemService {
	
	@Autowired
	private CategoriaItemRepository categoriaItemRepository;
	
	public Iterable<CategoriaItem> findAll() {
		return categoriaItemRepository.findAll();
	}
}
