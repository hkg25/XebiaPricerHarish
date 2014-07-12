package com.xebia.pricer.dao;

import java.util.List;

public interface AbstractDao<E> {
	
	public E upsert(E object);

	public E getById(Object key);
	
	public E delete(E object);
	
	public List<E> getAll();
}
