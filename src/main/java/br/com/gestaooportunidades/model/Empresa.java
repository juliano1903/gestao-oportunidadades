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
public class Empresa {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "empresa_seq")
	@SequenceGenerator(sequenceName = "empresa_id_seq", allocationSize = 1, name = "empresa_seq")
	private Long idEmpresa;
	
	private String nome;
	
	private String nomeFantasia;
	
	private String cnpj;
	
	private String endereco;
}
