package br.com.leilaoeletronico.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class CategoriaItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categoria_item_seq" )
	@SequenceGenerator(sequenceName = "categoria_item_id_seq", allocationSize = 1, name ="categoria_item_seq")
	public Long idCategoriaItem;
	
	public String nome;
}
