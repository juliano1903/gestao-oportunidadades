package br.com.gestaooportunidades.model;

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
public class UsuarioOportunidade {


	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator =  "usuario_oportunidade_seq")
	@SequenceGenerator(sequenceName = "usuario_oportunidade_id_seq", allocationSize = 1, name = "usuario_oportunidade_seq")
	private Long idUsuarioOportunidade;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_oportunidade")
	private Oportunidade oportunidade;
	
	private Date dataCandidatura;
	
}
