package com.xebia.pricer.service;

import java.util.List;

public interface AbstractService<E> {

	public E upsert(E object);

	public E getById(Object key);
	
	public List<E> getAll();
}
