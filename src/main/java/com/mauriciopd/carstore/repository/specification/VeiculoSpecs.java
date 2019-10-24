package com.mauriciopd.carstore.repository.specification;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.mauriciopd.carstore.domain.Veiculo;

public class VeiculoSpecs {

	public static Specification<Veiculo> findByMarcaAndOpcionais(String marca, List<String> opcionais) {
		return new Specification<Veiculo>() {
			private static final long serialVersionUID = 1L;

			public Predicate toPredicate(Root<Veiculo> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				List<Predicate> predicates = new ArrayList<>();
				
				if(!marca.isEmpty()) {
					predicates.add(builder.equal(builder.lower(root.get("modelo").get("marca").get("nome")), marca.toLowerCase()));
				}
				
				if(!opcionais.isEmpty()) {
					for(String nome: opcionais) {
						predicates.add(builder.like(builder.lower(root.join("opcionais").get("nome")), "%" + nome.toLowerCase() + "%"));
						
					}
				}

				query.distinct(true);
	     
				return builder.and(predicates.toArray(new Predicate[1]));
			}
		};
	}
	
	public static Specification<Veiculo> findByCarroCustom(
			String marca,
			List<String> opcionais,
			Integer deAno,
			Integer ateAno,
			Double dePreco,
			Double atePreco,
			Long deKm,
			Long ateKm,
			List<Integer> cores,
			List<Integer> cambios,
			List<Integer> combustivel,
			List<Integer> tipoCarro) {
		return new Specification<Veiculo>() {
			private static final long serialVersionUID = 1L;

			public Predicate toPredicate(Root<Veiculo> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				List<Predicate> predicates = new ArrayList<>();
				
				
				if(!marca.isEmpty()) {
					predicates.add(builder.equal(builder.lower(root.get("modelo").get("marca").get("nome")), marca.toLowerCase()));
				}
				
				if(!opcionais.isEmpty()) {
					for(String nome: opcionais) {
						predicates.add(builder.like(builder.lower(root.join("opcionais").get("nome")), "%" + nome.toLowerCase() + "%"));
						
					}
				}
				
				//Verifica ano
				
				if(deAno != 0 && ateAno != 0) {
					predicates.add(builder.between(root.get("ano"), deAno, ateAno));
				}
				
				if(deAno != 0 && ateAno == 0) {
					predicates.add(builder.greaterThanOrEqualTo(root.get("ano"), deAno));
				}
				
				if(ateAno != 0 && deAno == 0) {
					predicates.add(builder.lessThanOrEqualTo(root.get("ano"), ateAno));
				}
				
				//Verifica preco
				
				if(dePreco != 0 && atePreco != 0) {
					predicates.add(builder.between(root.get("preco"), dePreco, atePreco));
				}
				
				if(dePreco != 0 && atePreco == 0) {
					predicates.add(builder.greaterThanOrEqualTo(root.get("preco"), dePreco));
				}
				
				if(atePreco != 0 && dePreco == 0) {
					predicates.add(builder.lessThanOrEqualTo(root.get("preco"), atePreco));
				}
				
				//Verifica km
				
				if(deKm != 0 && ateKm != 0) {
					predicates.add(builder.between(root.get("kmRodado"), deKm, ateKm));
				}
				
				if(deKm != 0 && ateKm == 0) {
					predicates.add(builder.greaterThanOrEqualTo(root.get("kmRodado"), deKm));
				}
				
				if(ateKm != 0 && deKm == 0) {
					predicates.add(builder.lessThanOrEqualTo(root.get("kmRodado"), ateKm));
				}
				
				//Verifica cor
				
				if(cores.get(0) != 0) {
					predicates.add(root.get("cor").in(cores));
				}
				
				//Verifica cambio
				
				if(cambios.get(0) != 0) {
					predicates.add(root.get("cambio").in(cambios));
				}
				
				//Verifica combustivel
				
				if(combustivel.get(0) != 0) {
					predicates.add(root.get("combustivel").in(combustivel));
				}
				
				//Verifica tipo carro
				if(tipoCarro.get(0) != 0) {
					predicates.add(root.get("tipo").in(tipoCarro));
				}
				
				query.distinct(true);
	     
				return builder.and(predicates.toArray(new Predicate[1]));
			}
		};
	}

}
