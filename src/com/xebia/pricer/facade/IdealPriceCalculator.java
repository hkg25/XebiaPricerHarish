package com.xebia.pricer.facade;

import java.util.List;

import com.xebia.pricer.entity.StorePrice;

//A new implementation can be made and plugged in when needed
// If using relational DB like MySQL we can store formula in DB or properties file that can be added to query
public interface IdealPriceCalculator {
	
	 public Double calculateIdealPrice(List<StorePrice> storePrices);
	 
	 public Double calculateAveragePrice(List<StorePrice> storePrices);
}
