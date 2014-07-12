package com.xebia.pricer.comparator;

import java.util.Comparator;

import com.xebia.pricer.entity.StorePrice;

public class StorePriceComparator implements Comparator<StorePrice> {

	@Override
	public int compare(StorePrice o1, StorePrice o2) {
		return o1.getPrice().compareTo(o2.getPrice());
	}


}
