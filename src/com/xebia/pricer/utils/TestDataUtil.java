package com.xebia.pricer.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.xebia.pricer.entity.Product;
import com.xebia.pricer.entity.StorePrice;

public class TestDataUtil {

	List<Product> products;
	List<StorePrice> storePrices;
	
	static TestDataUtil self=null;
	
	private TestDataUtil(){
		products = new ArrayList<Product>();
		storePrices = new ArrayList<StorePrice>();
		populateProducts();
		populateStorePrices();
	}
	
	private void populateStorePrices() {
		int counter = 1;
		Random random = new Random();
		int price;
		for(Product product : products){
			price =random.nextInt(100);
			storePrices.add(new StorePrice(counter++, "Easy Day", product.getBarCode(), price + random.nextDouble(), "agent1"));
			storePrices.add(new StorePrice(counter++, "Big Bazaar",product.getBarCode(), price + random.nextDouble(), "agent2"));
			storePrices.add(new StorePrice(counter++, "Reliance", product.getBarCode(), price + random.nextDouble(), "agent3"));
			storePrices.add(new StorePrice(counter++, "Six Ten",product.getBarCode(), price + random.nextDouble(), "agent4"));
			storePrices.add(new StorePrice(counter++, "Spencer", product.getBarCode(), price + random.nextDouble(), "agent5"));
		}
	}

	private void populateProducts() {
		products.add(new Product("aa1", "Amul Cheese", "", "admin"));
		products.add(new Product("aa2", "Harvest brown bread", "", "admin"));
		products.add(new Product("aa3", "Harvest white bread", "", "admin"));
		products.add(new Product("aa4", "Snickers Chocolate", "", "admin"));
		products.add(new Product("aa5", "Cadbury chocolate", "", "admin"));
		products.add(new Product("aa6", "Kit kat chocolate", "", "admin"));
		products.add(new Product("aa7", "Perk chocolate", "", "admin"));
		products.add(new Product("aa8", "Uncle Chips", "", "admin"));
		products.add(new Product("aa9", "Lays Chips", "", "admin"));
		products.add(new Product("aa10", "Coca Cola", "", "admin"));
		
	}

	public void addProduct(Product product){
		products.add(product);
	}
	
	public List<Product> getProducts() {
		return products;
	}

	public List<StorePrice> getStorePrices() {
		return storePrices;
	}

	public void addStorePrice(StorePrice storePrice){
		storePrices.add(storePrice);
	}
	
	public static TestDataUtil getInstance(){
		if(self==null){
			self = new TestDataUtil();
		}
		return self;
	}
}
