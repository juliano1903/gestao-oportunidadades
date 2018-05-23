package br.com.leilaoeletronico.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="natureza_leilao")
public class NaturezaLeilao {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "natureza_leilao_seq" )
	@SequenceGenerator(sequenceName = "natureza_leilao_id_seq", allocationSize = 1, name ="natureza_leilao_seq")
	private Long idNaturezaLeilao;
	
	private String nome;
	
	@Column(columnDefinition="varchar2(4000)")
	private String descricao;
}
