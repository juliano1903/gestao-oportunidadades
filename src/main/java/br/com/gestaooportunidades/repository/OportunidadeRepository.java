package br.com.gestaooportunidades.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.gestaooportunidades.model.Oportunidade;
import br.com.gestaooportunidades.model.Usuario;

public interface OportunidadeRepository extends JpaRepository<Oportunidade, Long>{
	
	@Modifying
	@Query ("update Oportunidade op "
			+ "set op.dataAprovacao = :dataAprovacao "
			+ "where op.idOportunidade = :idOportunidade")
	public void udateDataAprovacao(@Param("idOportunidade") Long idOportunidade, @Param("dataAprovacao") Date dataAprovacao);

	@Modifying
	@Query ("update Oportunidade op "
			+ "set op.dataReprovacao = :dataReprovacao "
			+ "where op.idOportunidade = :idOportunidade")
	public void udateDataReprovacao(@Param("idOportunidade") Long idOportunidade, @Param("dataReprovacao") Date dataReprovacao);
}
