package com.how2java.action;

import java.util.Date;
import java.util.List;

import com.how2java.dao.ProductDAO;
import com.how2java.pojo.Product;

public class ProductAction {
	private ProductDAO pdao;
	private List<Product> products;
	private Product p;
	
	public String list() {
		products = pdao.find("from Product p");
			
		return "listJsp";
	}
	
	public String save(){		
		pdao.save(p);
		products = pdao.find("from Product p");
		return "save";
	}
	
	
	public ProductDAO getPdao() {
		return pdao;
	}

	public void setPdao(ProductDAO pdao) {
		this.pdao = pdao;
	}

	

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	
	public void setProduct(Product p) {
		this.p = p;
	}

	

	public Product getProduct() {
		return p;
	}
}
