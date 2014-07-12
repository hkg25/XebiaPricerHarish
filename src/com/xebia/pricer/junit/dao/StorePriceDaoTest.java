package com.xebia.pricer.junit.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.xebia.pricer.dao.StorePriceDao;
import com.xebia.pricer.dao.impl.StorePriceDaoImpl;
import com.xebia.pricer.entity.StorePrice;

public class StorePriceDaoTest {

	StorePriceDao storePriceDao =null;
	String barCode = null;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		storePriceDao = new StorePriceDaoImpl();
		 barCode = "aa5"; // existing bar code
	}

	@After
	public void tearDown() throws Exception {
		storePriceDao =null;
	}

	@Test
	public void testGetByProductBarCode() {
		assertTrue(storePriceDao.getByProductBarCode(barCode).size()>0);
	}

	@Test
	public void testGetMaxPrice() {
		List<StorePrice> list = storePriceDao.getByProductBarCode(barCode);
		Double max = 0.0;
		for(StorePrice storePrice : list){
			if(storePrice.getPrice()>max){
				max = storePrice.getPrice();
			}
		}
		assertEquals(max, storePriceDao.getMaxPrice(barCode));
	}

	@Test
	public void testGetMinPrice() {
		List<StorePrice> list = storePriceDao.getByProductBarCode(barCode);
		Double min = Double.MAX_VALUE;
		for(StorePrice storePrice : list){
			if(storePrice.getPrice()<min){
				min = storePrice.getPrice();
			}
		}
		assertEquals(min, storePriceDao.getMinPrice(barCode));
	}

	@Test
	public void testUpsert() {
		int currentListSize = storePriceDao.getAll().size();
		storePriceDao.upsert(new StorePrice(2000, "Reliance", "aa8", 353.8, "agent3"));
		assertEquals(currentListSize+1, storePriceDao.getAll().size());
	}

	@Test
	public void testGetById() {
		StorePrice storePrice = storePriceDao.getById(1);
		assertNotNull(storePrice);
		assertEquals("Easy Day", storePrice.getStore());
		
	}

	@Test
	public void testGetAll() {
		assertNotNull(storePriceDao.getAll());
		assertTrue(storePriceDao.getAll().size()>0);
	}

}
