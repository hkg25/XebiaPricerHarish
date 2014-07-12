package com.xebia.pricer.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xebia.pricer.entity.StorePrice;
import com.xebia.pricer.service.ProductService;
import com.xebia.pricer.service.StorePriceService;
import com.xebia.pricer.service.impl.ProductServiceImpl;
import com.xebia.pricer.service.impl.StorePriceServiceImpl;

import flexjson.JSONDeserializer;

public class StorePriceServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	ProductService productService = new ProductServiceImpl();
	
	StorePriceService storePriceService = new StorePriceServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String url = req.getPathInfo().toString();
			if("".equals(url)){
				
			}else if("".equals(url)){
				
			}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String url = req.getPathInfo().toString();
			if("/save".equals(url)){
				save(req,resp);
			}else if("".equals(url)){
				
			}
	}

	private void save(HttpServletRequest request, HttpServletResponse resp) throws IOException {
		/*StringBuilder sb = new StringBuilder();
        String s;
        while ((s = request.getReader().readLine()) != null) {
            sb.append(s);
        }
        System.out.println(sb);*/
        StorePrice storePrice = new JSONDeserializer<StorePrice>().deserialize(request.getReader(),StorePrice.class);
		storePriceService.upsert(storePrice);
		System.out.println(storePrice);
	}

}
