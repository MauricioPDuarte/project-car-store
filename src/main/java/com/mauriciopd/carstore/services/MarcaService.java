package com.mauriciopd.carstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.mauriciopd.carstore.domain.Marca;
import com.mauriciopd.carstore.dto.MarcaDTO;
import com.mauriciopd.carstore.repository.MarcaRepository;

@Service
public class MarcaService {

	@Autowired
	private MarcaRepository repo;

	public Marca insert(Marca marca) {
		return repo.save(marca);
	}

	public List<Marca> findAll() {
		return repo.findAll();
	}

	public Marca findById(Integer id) {
		Optional<Marca> marca = repo.findById(id);
		return marca.orElseThrow(() -> new RuntimeException("Objeto não encontrado: " + id));
	}

	public void delete(Integer id) {
		findById(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException(
					"Não é possível excluir uma marca que possui modelos/carros cadastrados");
		}
	}

	public Marca atualizar(Marca obj) {
		Marca newMarca = findById(obj.getId());
		updateData(newMarca, obj);
		return repo.save(newMarca);
	}

	private void updateData(Marca newMarca, Marca obj) {
		newMarca.setNome(obj.getNome());
	}

	public Marca fromDTO(MarcaDTO obj) {
		return new Marca(obj.getId(), obj.getNome());
	}
}
