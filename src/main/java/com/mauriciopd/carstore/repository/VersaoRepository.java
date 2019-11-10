package com.mauriciopd.carstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mauriciopd.carstore.domain.Versao;

@Repository
public interface VersaoRepository extends JpaRepository<Versao, Integer>{

	@Transactional(readOnly=true)
	@Query("SELECT obj FROM Versao obj WHERE obj.modelo.id = :modeloId ORDER BY obj.nome")
	List<Versao> findAllByModeloId(@Param("modeloId") Integer modelo_id);
}
