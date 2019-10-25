package com.mauriciopd.carstore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mauriciopd.carstore.domain.Colaborador;
import com.mauriciopd.carstore.repository.ColaboradorRepository;
import com.mauriciopd.carstore.security.UserSS;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private ColaboradorRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Colaborador obj = repo.findByEmail(email);
		
		if(obj == null) {
			throw new UsernameNotFoundException(email);
		}
		
		return new UserSS(obj.getId(), obj.getEmail(), obj.getSenha(), obj.getPerfis());
	}

}
