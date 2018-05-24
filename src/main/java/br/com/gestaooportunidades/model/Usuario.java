package br.com.gestaooportunidades.model;

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
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_seq" )
	@SequenceGenerator(sequenceName = "usuario_id_seq", allocationSize = 1, name ="usuario_seq")
	private Long idUsuario;
	
	private String nome;
	
	private String cpf;
	
	private String email;
	
	private String senha;
	
	private Long idTipoUsuario;
}
