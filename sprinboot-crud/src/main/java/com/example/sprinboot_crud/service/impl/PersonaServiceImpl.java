package com.example.sprinboot_crud.service.impl;

import org.springframework.beans.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.*;

import com.example.sprinboot_crud.commons.GenericServiceImpl;
import com.example.sprinboot_crud.dao.PersonaDAO;
import com.example.sprinboot_crud.model.Persona;
import com.example.sprinboot_crud.service.PersonaService;


@Service
public class PersonaServiceImpl extends GenericServiceImpl<Persona, Long> implements PersonaService {
	
	@Autowired
	private PersonaDAO personaDao;
	
	@Override
	public CrudRepository<Persona,Long> getDao(){
		return personaDao;
	}
	
	

}
