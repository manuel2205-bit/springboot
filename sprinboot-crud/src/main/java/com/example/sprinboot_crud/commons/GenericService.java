package com.example.sprinboot_crud.commons;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;



public interface GenericService<T, ID extends Serializable> {
	

	
	void delete(ID id);
	
	T get(ID id);
	
	List<T> getAll();

	T save(T entity);

	

	


	
	

}
