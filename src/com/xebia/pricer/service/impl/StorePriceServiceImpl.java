package com.xebia.pricer.service.impl;

import java.util.List;

import com.xebia.pricer.dao.StorePriceDao;
import com.xebia.pricer.dao.impl.StorePriceDaoImpl;
import com.xebia.pricer.entity.StorePrice;
import com.xebia.pricer.service.StorePriceService;

public class StorePriceServiceImpl implements StorePriceService {
	
	StorePriceDao storePriceDao = new StorePriceDaoImpl();

	@Override
	public StorePrice upsert(StorePrice object) {
		return storePriceDao.upsert(object);
	}

	@Override
	public StorePrice getById(Object key) {
		return storePriceDao.getById(key);
	}

	@Override
	public List<StorePrice> getAll() {
		return storePriceDao.getAll();
	}

	@Override
	public List<StorePrice> getByProductBarCode(String barcode) {
		return storePriceDao.getByProductBarCode(barcode);
	}

	@Override
	public Double getMaxPrice(String barcode) {
		return storePriceDao.getMaxPrice(barcode);
	}

	@Override
	public Double getMinPrice(String barcode) {
		return storePriceDao.getMinPrice(barcode);
	}


}
