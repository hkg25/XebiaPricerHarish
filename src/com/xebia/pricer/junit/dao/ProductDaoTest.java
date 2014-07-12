package com.xebia.pricer.junit.dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.xebia.pricer.dao.ProductDao;
import com.xebia.pricer.dao.StorePriceDao;
import com.xebia.pricer.dao.impl.ProductDaoImpl;
import com.xebia.pricer.dao.impl.StorePriceDaoImpl;
import com.xebia.pricer.entity.Product;

public class ProductDaoTest {

	ProductDao productDao = null;
	String barCode = null;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		productDao = new ProductDaoImpl();
		 barCode = "aa5"; // existing bar code
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSearchBarCode() {
		assertTrue(productDao.searchBarCode(barCode).size()>0);
	}

	@Test
	public void testUpsert() {
		int currentListSize = productDao.getAll().size();
		productDao.upsert(new Product("aa11", "Slice", "", "admin"));
		assertEquals(currentListSize+1, productDao.getAll().size());
	}

	@Test
	public void testGetById() {
		Product product = productDao.getById(barCode);
		assertNotNull(product);
		assertEquals("Cadbury chocolate", product.getName());
	}

	@Test
	public void testGetAll() {
		assertNotNull(productDao.getAll());
		assertTrue(productDao.getAll().size()>0);
	}

}
