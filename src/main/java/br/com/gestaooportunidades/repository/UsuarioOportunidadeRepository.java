package br.com.gestaooportunidades.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.gestaooportunidades.model.UsuarioOportunidade;

public interface UsuarioOportunidadeRepository extends JpaRepository<UsuarioOportunidade, Long>{

	@Query("select uo from UsuarioOportunidade uo "
			+ "join fetch uo.oportunidade op "
			+ "where uo.usuario.idUsuario = :idUsuario")
	public Iterable<UsuarioOportunidade>findAllByIdUsuario(@Param("idUsuario") Long idUsuario);

	@Query("select uo from UsuarioOportunidade uo "
			+ "where uo.usuario.idUsuario = :idUsuario "
			+ "and uo.oportunidade.idOportunidade = :idOportunidade ")
	public Iterable<UsuarioOportunidade> findByIdUsuarioAndIdOportunidade(@Param("idUsuario") Long idUsuario, @Param("idOportunidade") Long idOportunidade);

}
