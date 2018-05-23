package br.com.leilaoeletronico.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
public class Lote {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lote_seq")
	@SequenceGenerator(sequenceName = "lote_id_seq", allocationSize = 1, name = "lote_seq")
	private Long idLote;
	
	private String descricao;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "lote_item", joinColumns = {
			@JoinColumn(name = "id_item", nullable = false, updatable = false) },
			inverseJoinColumns = { @JoinColumn(name = "id_lote",
					nullable = false, updatable = false) })
	private List<Item> itens;
}
