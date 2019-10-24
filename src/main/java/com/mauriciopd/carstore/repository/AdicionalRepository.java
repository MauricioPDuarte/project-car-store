package com.mauriciopd.carstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mauriciopd.carstore.domain.Adicional;

@Repository
public interface AdicionalRepository extends JpaRepository<Adicional, Integer>{

}
