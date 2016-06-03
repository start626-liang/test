package com.how2java.action;

import java.util.List;

import com.how2java.dao.ProductDAO;
import com.how2java.pojo.Product;

public class ProductAction {
	ProductDAO pdao;
	List<Product> products;
	Product p;
	
	public String list() {
		products = pdao.find("from Product p");
		
		if(products.isEmpty()){
			for (int i = 0; i < 5; i++) {
				Product p =new Product();
				p.setName("name"+i);
				p.setPrice(i);
				pdao.save(p);
			}
			products = pdao.find("from Product p");
		}
		
		
		
		return "listJsp";
	}
	
	public String save(){		
		pdao.save(p);
		products = pdao.find("from Product p");
		return "save";
	}
	
	public String edit(){
		p = pdao.get(Product.class, p.getId());
		return "edit";
	}
	
	 public String update() {
		 pdao.update(p);
		 System.out.println("22222222222222");
		 products = pdao.find("from Product p");
	     return "update";
	 }
	 
	 public String delete() {
		 p = pdao.get(Product.class, p.getId());
		 pdao.delete(p);
		 
		 products = pdao.find("from Product p");
	     return "delete";
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
