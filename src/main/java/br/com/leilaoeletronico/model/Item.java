package br.com.leilaoeletronico.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_seq" )
	@SequenceGenerator(sequenceName = "item_id_seq", allocationSize = 1, name ="item_seq")
	private Long idItem;
	
	@ManyToOne
	@JoinColumn(name="id_categoria_item")
	private CategoriaItem categoria;
	
	private String nome;
	
	private String descricao;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "itens")
	private List<Lote> lotes;

}
