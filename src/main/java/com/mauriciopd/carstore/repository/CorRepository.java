package com.mauriciopd.carstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mauriciopd.carstore.domain.Cor;

@Repository
public interface CorRepository extends JpaRepository<Cor, Integer>{
	
}
