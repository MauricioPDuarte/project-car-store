package com.mauriciopd.carstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mauriciopd.carstore.domain.Cambio;

@Repository
public interface CambioRepository extends JpaRepository<Cambio, Integer>{
	
}
