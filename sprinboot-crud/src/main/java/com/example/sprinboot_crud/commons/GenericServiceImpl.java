package com.example.sprinboot_crud.commons;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

public abstract class GenericServiceImpl<T, ID extends Serializable> implements GenericService<T, ID> {
	
	
	@Override
	public T save(T entity) {
		return getDao().save(entity);
	}
	
	@Override
	public void delete(ID id) {
		getDao().deleteById(id);
	}
	
	
	@Override
	public T get(ID id) {
		Optional<T> obj = getDao().findById(id);
		if(obj.isPresent()) {
			return obj.get();
		}
		
		return null;
		
	}
	
	public List<T> getAll(){
		
		List<T> returnList = new ArrayList<>();
		getDao().findAll().forEach(obj -> returnList.add(obj));
		return returnList;
	}
	
	
	
	

	protected abstract CrudRepository<T, ID> getDao();

}
