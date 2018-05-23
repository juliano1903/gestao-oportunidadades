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
public class Lance {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lance_seq")
	@SequenceGenerator(sequenceName = "lance_id_seq", allocationSize = 1, name = "lance_seq")
	private Long idLance;
	
	private Date dataHora;
	
	private Long valor;

	private String valorString;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_leilao")
	private Leilao leilao;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_usuario")
	private Usuario usuario;
}
