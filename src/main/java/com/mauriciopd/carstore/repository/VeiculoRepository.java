package com.mauriciopd.carstore.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mauriciopd.carstore.domain.Veiculo;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Integer>, JpaSpecificationExecutor<Veiculo>{
	
//	@Transactional(readOnly=true)
//	@Query("SELECT obj FROM Veiculo obj WHERE lower(obj.modelo.marca.nome) like lower(:marca) AND lower(obj.modelo.nome) like lower(:modelo)") 
//	List<Veiculo> findModelo(@Param("marca") String marca, @Param("modelo")String modelo);
	
//	@Transactional(readOnly=true)
//	@Query("SELECT obj FROM Veiculo obj WHERE lower(obj.modelo.marca.nome) like lower(:marca)") 
//	List<Veiculo> findMarca(@Param("marca") String marca);
	
//	@Transactional(readOnly=true)
//	@Query("SELECT obj FROM Veiculo obj WHERE lower(obj.modelo.marca.nome) like lower(:marca)") 
//	Page<Veiculo> findMarcaPage(@Param("marca") String marca, Pageable pageable);
//	
//	@Transactional(readOnly=true)
//	@Query("SELECT obj FROM Veiculo obj WHERE lower(obj.modelo.marca.nome) like lower(:marca) AND lower(obj.modelo.nome) like lower(:modelo)") 
//	Page<Veiculo> findModeloPage(@Param("marca") String marca, @Param("modelo")String modelo, Pageable pageable);
	
	@Transactional(readOnly=true)
	Page<Veiculo> findByModeloMarcaNomeIgnoreCase(@Param("marca") String marca, Pageable pageable);
	
	@Transactional(readOnly=true)
	Page<Veiculo> findByModeloMarcaNomeAndModeloNomeAllIgnoreCase(@Param("marca") String marca, @Param("modelo")String modelo, Pageable pageable);
	
	@Transactional(readOnly=true)
	List<Veiculo> findByModeloMarcaNomeIgnoreCase(String marca);
	
	@Transactional(readOnly=true)
	List<Veiculo> findByModeloMarcaNomeAndModeloNomeAllIgnoreCase(String marca, String modelo);
	
	List<Veiculo> findAll(Specification<Veiculo> spec);
}