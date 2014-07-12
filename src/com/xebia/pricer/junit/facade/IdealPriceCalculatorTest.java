package com.xebia.pricer.junit.facade;

import static org.junit.Assert.*;

import java.util.Collections;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.xebia.pricer.comparator.StorePriceComparator;
import com.xebia.pricer.dao.StorePriceDao;
import com.xebia.pricer.dao.impl.StorePriceDaoImpl;
import com.xebia.pricer.entity.StorePrice;
import com.xebia.pricer.facade.IdealPriceCalculator;
import com.xebia.pricer.facade.impl.AvgMeanIdealPriceCalculator;

public class IdealPriceCalculatorTest {

	StorePriceDao storePriceDao =null;
	IdealPriceCalculator idealPriceCalculator = null;
	String barCode = null;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		idealPriceCalculator = new AvgMeanIdealPriceCalculator();
		storePriceDao = new StorePriceDaoImpl();
		 barCode = "aa5"; // existing bar code
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCalculateIdealPrice() {
		List<StorePrice> list = storePriceDao.getByProductBarCode(barCode);
		Collections.sort(list, new StorePriceComparator());
		if(list.size()>4){
			list = list.subList(2, list.size()-2);
		}
		Double sum = 0.0;
		for(StorePrice sp : list){
			sum = sum + sp.getPrice();
		}
		Double expectedAvg = sum / list.size();
		Double expectedPrice = expectedAvg + ((20*expectedAvg)/100);
		
		Double price = idealPriceCalculator.calculateIdealPrice( storePriceDao.getByProductBarCode(barCode));
		assertEquals(expectedPrice, price);
	}

	@Test
	public void testCalculateAveragePrice() {
		List<StorePrice> list = storePriceDao.getByProductBarCode(barCode);
		Double sum = 0.0;
		for(StorePrice sp : list){
			sum = sum + sp.getPrice();
		}
		Double expectedAvg = sum / list.size();
		Double avg = idealPriceCalculator.calculateAveragePrice(list);
		assertEquals(expectedAvg, avg);
		
	}

}
