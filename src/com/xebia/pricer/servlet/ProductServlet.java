package com.xebia.pricer.servlet;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.xebia.pricer.entity.Product;
import com.xebia.pricer.entity.StorePrice;
import com.xebia.pricer.facade.IdealPriceCalculator;
import com.xebia.pricer.facade.impl.AvgMeanIdealPriceCalculator;
import com.xebia.pricer.service.ProductService;
import com.xebia.pricer.service.StorePriceService;
import com.xebia.pricer.service.impl.ProductServiceImpl;
import com.xebia.pricer.service.impl.StorePriceServiceImpl;

public class ProductServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	ProductService productService = new ProductServiceImpl();
	StorePriceService storePriceService = new StorePriceServiceImpl();
	IdealPriceCalculator idealPriceCalculator;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String url = req.getPathInfo().toString();
			if("/list".equals(url)){
				showAll(resp);
			}else if("/detail".equals(url)){
				showDetail(req,resp);
			}else if("/fetchProduct".equals(url)){
				fetchProduct(req,resp);
			}
	}
	
	private void fetchProduct(HttpServletRequest req, HttpServletResponse response) throws IOException {
		String barcode = req.getParameter("term");
		List<Product> products = productService.searchBarCode(barcode);
		JSONArray array = new JSONArray();
		JSONObject json ;
		for(Product product : products){
			json = new JSONObject();
			try {
				json.put("label", product.getName() +"(" +product.getBarCode() +")");
				json.put("value", product.getBarCode());
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			array.put(json);
		}
		response.setContentType("application/json; charset=UTF-8");
		response.getWriter().print(array);
	}

	private void showDetail(HttpServletRequest req, HttpServletResponse response) throws IOException {
		String barcode = req.getParameter("barcode");
		Product product = productService.getById(barcode);
		List<StorePrice> storePrices = storePriceService.getByProductBarCode(barcode);
		idealPriceCalculator = new AvgMeanIdealPriceCalculator(); // can be wired to use any other calculation method
		double idealPrice = idealPriceCalculator.calculateIdealPrice(storePrices);
		DecimalFormat decimalFormat= new DecimalFormat("#.00");
		String idealPriceStr =decimalFormat.format(idealPrice);
		double avgPrice = idealPriceCalculator.calculateAveragePrice(storePrices);
		String avgPriceStr = decimalFormat.format(avgPrice);
		double maxPrice = storePriceService.getMaxPrice(barcode);
		double minPrice = storePriceService.getMinPrice(barcode);
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy HH:mm");
		JSONObject json = new JSONObject();
		try {
			json.put("name", product.getName());
			json.put("barcode",product.getBarCode() );
			json.put("notes", product.getNotes());
			json.put("createdBy",product.getCreatedBy() );
			json.put("date", formatter.format(product.getCreatedDate()));
			json.put("maxPrice", decimalFormat.format(maxPrice));
			json.put("minPrice", decimalFormat.format(minPrice));
			json.put("idealPrice", avgPriceStr);
			json.put("avgPrice", idealPriceStr);
			json.put("itemSize", storePrices.size());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		response.setContentType("application/json; charset=UTF-8");
		response.getWriter().print(json);
		
	}

	private void showAll(HttpServletResponse response) throws IOException {
		JSONObject json = new JSONObject();
		JSONArray array = new JSONArray();
		List<Product> products = productService.getAll();
		try {
			json.put("page", 1);
			json.put("total", products.size());
			json.put("records",20 );
			int counter = 1;
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy HH:mm");
			JSONObject rowData = null;
			JSONArray cellData = null;
			for(Product product : products){
				rowData = new JSONObject();
				 cellData = new JSONArray();
				cellData.put(product.getName());
				cellData.put(product.getBarCode());
				cellData.put(product.getCreatedBy());
				cellData.put(formatter.format(product.getCreatedDate()));
				rowData.put("cell", cellData);
				rowData.put("id", counter++);
				array.put(rowData);
			}
			json.put("rows", array);
			response.setContentType("application/json; charset=UTF-8");
			response.getWriter().print(json);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String url = req.getPathInfo().toString();
			if("".equals(url)){
				
			}else if("".equals(url)){
				
			}
	}

}
