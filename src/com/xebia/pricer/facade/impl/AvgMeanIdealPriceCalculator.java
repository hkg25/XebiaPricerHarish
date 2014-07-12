package com.xebia.pricer.facade.impl;

import java.util.Collections;
import java.util.List;

import com.xebia.pricer.comparator.StorePriceComparator;
import com.xebia.pricer.entity.StorePrice;
import com.xebia.pricer.facade.IdealPriceCalculator;

/*Ideal Price. This price is calculated by taking all the prices of this product,

removing the 2 highest and 2 lowest, then doing an average with the rest 

and adding 20% to it.*/
public class AvgMeanIdealPriceCalculator implements IdealPriceCalculator{

	@Override
	public Double calculateIdealPrice(List<StorePrice> storePrices) {
		List<StorePrice> listForCalculation = storePrices;
		Collections.sort(listForCalculation,new StorePriceComparator());
		if(storePrices.size()>4){
			listForCalculation = storePrices.subList(2, storePrices.size()-2);
		}
		Double idealPrice =0.0;
		for(StorePrice storePrice : listForCalculation){
			idealPrice += storePrice.getPrice(); // sum all
		} 
		idealPrice /= listForCalculation.size(); // get average
		
		idealPrice += 0.2*idealPrice ; // add 20%
		return idealPrice;
	}

	@Override
	public Double calculateAveragePrice(List<StorePrice> storePrices) {
		Double avgPrice =0.0;
		for(StorePrice storePrice : storePrices){
			avgPrice += storePrice.getPrice(); // sum all
		} 
		avgPrice /= storePrices.size(); // get average
		
		return avgPrice;
	}

}
