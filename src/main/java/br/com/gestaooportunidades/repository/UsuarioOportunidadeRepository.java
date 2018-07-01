package br.com.gestaooportunidades.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.gestaooportunidades.model.Oportunidade;
import br.com.gestaooportunidades.model.UsuarioOportunidade;

public interface UsuarioOportunidadeRepository extends JpaRepository<UsuarioOportunidade, Long>{

	@Query("select uo from UsuarioOportunidade uo "
			+ "join fetch uo.oportunidade op "
			+ "where uo.usuario.idUsuario = :idUsuario")
	public Iterable<UsuarioOportunidade>findAllByIdUsuario(@Param("idUsuario") Long idUsuario);

	@Query("select uo from UsuarioOportunidade uo "
			+ "where uo.usuario.idUsuario = :idUsuario "
			+ "and uo.oportunidade.idOportunidade = :idOportunidade "
			+ "and uo.dataCancelamento = null ")
	public Iterable<UsuarioOportunidade> findByIdUsuarioAndIdOportunidade(@Param("idUsuario") Long idUsuario, @Param("idOportunidade") Long idOportunidade);


	@Query("select uo from UsuarioOportunidade uo "
			+ "where uo.oportunidade.idOportunidade = :idOportunidade ")
	public Iterable<UsuarioOportunidade> findByIdOportunidade(@Param("idOportunidade") Long idOportunidade);

	public void deleteByOportunidade(Oportunidade oportunidade);
	
	@Modifying
	@Query("update UsuarioOportunidade uo "
			+ "set uo.dataCancelamento = :dataCancelamento "
			+ "where uo.oportunidade.idOportunidade = :idOportunidade ")
	public void udateDataCancelamentoByIdOportunidade(@Param("idOportunidade") Long idOportunidade, @Param("dataCancelamento") Date dataCancelamento);


	@Modifying
	@Query("update UsuarioOportunidade uo "
			+ "set uo.dataCancelamento = :dataCancelamento "
			+ "where uo.idUsuarioOportunidade = :idUsuarioOportunidade ")
	public void udateDataCancelamentoByIdUsuarioOportunidade(@Param("idUsuarioOportunidade") Long idUsuarioOportunidade, @Param("dataCancelamento") Date dataCancelamento);

}
