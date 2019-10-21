package com.mauriciopd.carstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mauriciopd.carstore.domain.Opcional;

@Repository
public interface OpcionalRepository extends JpaRepository<Opcional, Integer>{

}
