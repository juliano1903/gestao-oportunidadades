package br.com.leilaoeletronico.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Leilao {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "leilao_seq")
	@SequenceGenerator(sequenceName = "leilao_id_seq", allocationSize = 1, name = "leilao_seq")
	private Long idLeilao;
	
	@ManyToOne
	@JoinColumn(name="id_lote")
	private Lote lote;
	
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name="id_natureza_leilao")
	private NaturezaLeilao naturezaLeilao;
	
	@ManyToOne
	@JoinColumn(name="id_tipo_lance")
	private TipoLance tipoLance;
	
	private Date dataInicio;
	
	private Date dataFim;
	
	private Long valor;
	
	private String valorString;
	
	@Transient
	private String lanceVencedor;
	
	@Transient
	public boolean finalizado;
}
