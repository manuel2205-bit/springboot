package com.example.sprinboot_crud.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.example.sprinboot_crud.commons.GenericService;
import com.example.sprinboot_crud.model.Persona;

import java.io.Serializable;


@Service
public interface PersonaService extends GenericService<Persona,Long> {

}
