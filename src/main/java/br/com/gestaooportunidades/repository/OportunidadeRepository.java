package br.com.gestaooportunidades.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.gestaooportunidades.model.Empresa;
import br.com.gestaooportunidades.model.Oportunidade;

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
	
	@Modifying
	@Query ("update Oportunidade op "
			+ "set op.dataCancelamento = :dataCancelamento "
			+ "where op.idOportunidade = :idOportunidade")
	public void udateDataCancelamento(@Param("idOportunidade") Long idOportunidade, @Param("dataCancelamento") Date dataCancelamento);

	@Query("select op from Oportunidade op "
			+ "where op.dataAprovacao != null "
			+ "and op.dataReprovacao = null "
			+ "and op.dataCancelamento = null ")
	public Iterable<Oportunidade> findAllDisponiveis();

	public Iterable<Oportunidade> findByEmpresa(Empresa empresa);
	
}
