package com.mauriciopd.carstore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mauriciopd.carstore.domain.Versao;
import com.mauriciopd.carstore.repository.VersaoRepository;

@Service
public class VersaoService {
	
	@Autowired
	private VersaoRepository repo;
	
	public List<Versao> findAllVersaoByModelo(Integer modeloId) {
		return repo.findAllByModeloId(modeloId);
	}

	
	
}
