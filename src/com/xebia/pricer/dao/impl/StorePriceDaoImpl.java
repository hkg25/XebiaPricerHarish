package com.xebia.pricer.dao.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.xebia.pricer.comparator.StorePriceComparator;
import com.xebia.pricer.dao.StorePriceDao;
import com.xebia.pricer.entity.Product;
import com.xebia.pricer.entity.StorePrice;
import com.xebia.pricer.utils.TestDataUtil;

//temp dao to show working

public class StorePriceDaoImpl implements StorePriceDao {

	@Override
	public StorePrice upsert(StorePrice object) {
		TestDataUtil.getInstance().addStorePrice(object);
		return object;
	}

	@Override
	public StorePrice getById(Object key) {
		for(StorePrice storePrice :  TestDataUtil.getInstance().getStorePrices()){
			if(key.equals(storePrice.getSerialNo())){
				return storePrice;
			}
		}
		return null;
	}

	@Override
	public StorePrice delete(StorePrice object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StorePrice> getAll() {
		return TestDataUtil.getInstance().getStorePrices();
	}

	@Override
	public List<StorePrice> getByProductBarCode(String barcode) {
		List<StorePrice> storePrices = new ArrayList<StorePrice>();
		for(StorePrice storePrice :  TestDataUtil.getInstance().getStorePrices()){
			if(barcode.equals(storePrice.getBarCode())){
				storePrices.add(storePrice);
			}
		}
		return storePrices;
	}

	@Override
	public Double getMaxPrice(String barcode) {
		List<StorePrice> storePrices =getByProductBarCode(barcode);
		Collections.sort(storePrices,new StorePriceComparator());
		return storePrices.get(storePrices.size()-1).getPrice();
	}

	@Override
	public Double getMinPrice(String barcode) {
		List<StorePrice> storePrices =getByProductBarCode(barcode);
		Collections.sort(storePrices,new StorePriceComparator());
		return storePrices.get(0).getPrice();
	}

}
