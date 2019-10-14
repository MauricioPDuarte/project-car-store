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
	@Query("SELECT obj FROM Veiculo obj WHERE obj.modelo.id = :modeloId") 
	List<Veiculo> findModelo(@Param("modeloId") Integer modelo_id);
	
	@Transactional(readOnly=true)
	@Query("SELECT obj FROM Veiculo obj WHERE obj.modelo.marca.id = :marcaId") 
	List<Veiculo> findMarca(@Param("marcaId") Integer marca_id);
}
