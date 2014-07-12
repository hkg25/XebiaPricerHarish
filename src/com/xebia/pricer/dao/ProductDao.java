package com.xebia.pricer.dao;

import java.util.List;

import com.xebia.pricer.entity.Product;

public interface ProductDao extends AbstractDao<Product>{

	List<Product> searchBarCode(String barcode);

}
