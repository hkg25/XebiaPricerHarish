package com.xebia.pricer.service;

import java.util.List;

import com.xebia.pricer.entity.Product;

public interface ProductService extends AbstractService<Product> {

	List<Product> searchBarCode(String barcode);

}
