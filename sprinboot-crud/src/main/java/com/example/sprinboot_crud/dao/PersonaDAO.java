package com.example.sprinboot_crud.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.sprinboot_crud.model.Persona;

public interface PersonaDAO extends CrudRepository<Persona, Long> {
	
	

}
