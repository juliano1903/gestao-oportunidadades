package br.com.leilaoeletronico.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
public class Oportunidade {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "oportunidade_seq")
	@SequenceGenerator(sequenceName = "oportunidade_id_seq", allocationSize = 1, name = "oportunidade_seq")
	private Long idOportunidade;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_empresa")
	private Empresa empresa;
	
	private String descricao;

	private String valorString;
	
	public Date data_aprovacao;
	
	public Date data_reprovacao;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_usuario")
	private Usuario usuario;
}
