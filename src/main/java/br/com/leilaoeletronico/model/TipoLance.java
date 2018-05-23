package br.com.leilaoeletronico.model;

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
@Table(name="tipo_lance")
public class TipoLance {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tipo_lance_seq" )
	@SequenceGenerator(sequenceName = "tipo_lance_id_seq", allocationSize = 1, name ="tipo_lance_seq")
	public Long idTipoLance;
	
	public String nome;
	
	public String descricao;

}
