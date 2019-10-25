package com.mauriciopd.carstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mauriciopd.carstore.domain.Colaborador;

@Repository
public interface ColaboradorRepository extends JpaRepository<Colaborador, Integer>{

	@Transactional(readOnly=true)
	Colaborador findByEmail(String email);
}
