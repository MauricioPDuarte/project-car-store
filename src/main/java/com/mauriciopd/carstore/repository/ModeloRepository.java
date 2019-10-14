package com.mauriciopd.carstore.repository;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mauriciopd.carstore.domain.Modelo;

@Repository
public interface ModeloRepository extends JpaRepository<Modelo, Integer>{
	
	@Transactional(readOnly=true)
	@Query("SELECT obj FROM Modelo obj WHERE obj.marca.id = :marcaId ORDER BY obj.nome")
	List<Modelo> findMarca(@Param("marcaId") Integer marca_id);
}
