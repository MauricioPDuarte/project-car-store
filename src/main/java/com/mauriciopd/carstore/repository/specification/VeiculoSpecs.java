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

}
