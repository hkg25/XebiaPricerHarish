package com.xebia.pricer.dao;

import java.util.List;

import com.xebia.pricer.entity.StorePrice;

public interface StorePriceDao extends AbstractDao<StorePrice>{

	List<StorePrice> getByProductBarCode(String barcode);
	
	Double getMaxPrice(String barcode);

	Double getMinPrice(String barcode);

	

}
