package com.example.sprinboot_crud.service.impl;

import com.example.sprinboot_crud.model.Usuario;
import com.example.sprinboot_crud.commons.UserRepository;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	 @Autowired
	    private UserRepository usuarioRepository;

	    @Override
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	    	System.out.println("Buscando usuario: " + username);
	        Usuario usuario = usuarioRepository.findByUsername(username);

	        if (usuario == null) {
	            throw new UsernameNotFoundException("Usuario no encontrado: " + username);
	        }
	        
	        System.out.println("Usuario encontrado: " + usuario.getUsername());

	        return new org.springframework.security.core.userdetails.User(usuario.getUsername(), usuario.getPassword(), AuthorityUtils.createAuthorityList(usuario.getRole()));
	    }
}