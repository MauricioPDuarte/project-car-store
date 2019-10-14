package com.mauriciopd.carstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mauriciopd.carstore.domain.Veiculo;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Integer>{
	
	@Transactional(readOnly=true)
	@Query("SELECT obj FROM Veiculo obj WHERE lower(obj.modelo.marca.nome) like lower(:marca) AND lower(obj.modelo.nome) like lower(:modelo)") 
	List<Veiculo> findModelo(@Param("marca") String marca, @Param("modelo")String modelo);
	
	@Transactional(readOnly=true)
	@Query("SELECT obj FROM Veiculo obj WHERE lower(obj.modelo.marca.nome) like lower(:marca)") 
	List<Veiculo> findMarca(@Param("marca") String marca);

}
