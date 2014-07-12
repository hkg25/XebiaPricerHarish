package com.xebia.pricer.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.xebia.pricer.dao.ProductDao;
import com.xebia.pricer.entity.Product;
import com.xebia.pricer.utils.TestDataUtil;

// temp dao to show working

public class ProductDaoImpl implements ProductDao{

	@Override
	public Product upsert(Product product) {
		TestDataUtil.getInstance().addProduct(product);
		return product;
	}

	@Override
	public Product getById(Object key) {
		for(Product product :  TestDataUtil.getInstance().getProducts()){
			if(key.equals(product.getBarCode())){
				return product;
			}
		}
		return null;
	}

	@Override
	public Product delete(Product object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getAll() {
		return TestDataUtil.getInstance().getProducts();
	}

	@Override
	public List<Product> searchBarCode(String barcode) {
		List<Product> list = new ArrayList<Product>();
		for(Product product :  TestDataUtil.getInstance().getProducts()){
			if(product.getBarCode().contains(barcode)){
				list.add( product);
			}
		}
		return list;
	}

}
