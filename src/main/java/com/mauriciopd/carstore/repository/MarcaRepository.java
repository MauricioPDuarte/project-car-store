package com.mauriciopd.carstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mauriciopd.carstore.domain.Marca;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Integer>{

}
