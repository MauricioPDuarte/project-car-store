package com.mauriciopd.carstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mauriciopd.carstore.domain.Combustivel;

@Repository
public interface CombustivelRepository extends JpaRepository<Combustivel, Integer>{
	
}
