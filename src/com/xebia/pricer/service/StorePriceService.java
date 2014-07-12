package com.xebia.pricer.service;

import java.util.List;

import com.xebia.pricer.entity.StorePrice;

public interface StorePriceService extends AbstractService<StorePrice>{

	List<StorePrice> getByProductBarCode(String barcode);
	
	Double getMaxPrice(String barcode);

	Double getMinPrice(String barcode);

}
