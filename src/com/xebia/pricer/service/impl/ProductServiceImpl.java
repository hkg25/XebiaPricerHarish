package com.xebia.pricer.service.impl;

import java.util.List;

import com.xebia.pricer.dao.ProductDao;
import com.xebia.pricer.dao.impl.ProductDaoImpl;
import com.xebia.pricer.entity.Product;
import com.xebia.pricer.service.ProductService;

public class ProductServiceImpl implements ProductService {

	ProductDao productDao = new ProductDaoImpl();
	
	
	@Override
	public Product upsert(Product object) {
		return productDao.upsert(object);
	}

	@Override
	public Product getById(Object key) {
		return productDao.getById(key);
	}

	@Override
	public List<Product> getAll() {
		return productDao.getAll();
	}

	@Override
	public List<Product> searchBarCode(String barcode) {
		// TODO Auto-generated method stub
		return productDao.searchBarCode(barcode);
	}

}
