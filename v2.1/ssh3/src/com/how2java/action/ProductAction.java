package com.how2java.action;


import java.util.List;

import com.how2java.dao.ProductDAO;
import com.how2java.pojo.Product;
import com.how2java.pojo.Product_java;
import com.how2java.pojo.Product_other;
import com.how2java.pojo.Product_sql;

public class ProductAction {
	private ProductDAO pdao;
	private String type;
	private String outputContent;
	private String outputName;
	
	
	private List<Product> products;
	private Product p;
	
	private List<Product_java> products_java;
	private Product_java p_java;
	
	private List<Product_sql> products_sql;
	private Product_sql p_sql;
	
	private List<Product_other> products_other;
	private Product_other p_other;
	
	public String list() {
		
		products  = pdao.find("from Product p");
		//products = pdao.find("from Product as p");
		return "listJsp";
	}
	
	public String show() {
		//System.out.println(p_java.getId() + "@@@@@@@@");
		//System.out.println(p_sql.getId() + "``````````````");
		//System.out.println(type + "!!!!!!!!!!");
		products_java = pdao.find("from Product_java p_java");
		products_sql = pdao.find("from Product_sql p_sql");
		products_other = pdao.find("from Product_other p_other");
		
		if(type.equals("SQL")){
			p_sql = pdao.get(Product_sql.class, p_sql.getId());
			
			outputName = p_sql.getName();
			outputContent = p_sql.getContent();
		}
		else if(type.equals("JAVA")){
			p_java = pdao.get(Product_java.class, p_java.getId());
			
			outputName = p_java.getName();
			outputContent = p_java.getContent();
		}
		else if(type.equals("Other")){
			p_other = pdao.get(Product_other.class, p_other.getId());
			
			outputName = p_other.getName();
			outputContent = p_other.getContent();
		}
		
		return "show";
	}
	
	
	
	public String save(){	
		pdao.save(p);
		//p_java.setContent("222");
		//p_java.setName("ss");
		//pdao.save(p_java);
		
		
		
		if(p.getType().equals("JAVA")){
			Product_java p_java =new Product_java();
			
			p_java.setContent(p.getContent());
			p_java.setName(p.getName());
			
			pdao.save(p_java);
		}else if(p.getType().equals("SQL")){
			Product_sql p_sql =new Product_sql();
			
			p_sql.setContent(p.getContent());
			p_sql.setName(p.getName());
			
			pdao.save(p_sql);
		}
		else{
			Product_other p_other =new Product_other();
			
			p_other.setContent(p.getContent());
			p_other.setName(p.getName());
			
			pdao.save(p_other);
		}
		
		products_java = pdao.find("from Product_java p_java");
		products_sql = pdao.find("from Product_sql p_sql");
		products_other = pdao.find("from Product_other p_other");
		return "save";
	}
	
	public String l() {
		products_java = pdao.find("from Product_java p_java");
		products_sql = pdao.find("from Product_sql p_sql");
		products_other = pdao.find("from Product_other p_other");
		return "l";
	}
	
	public ProductDAO getPdao() {
		return pdao;
	}

	public void setPdao(ProductDAO pdao) {
		this.pdao = pdao;
	}

	

	public List<Product_java> getProducts_java() {
		return products_java;
	}

	public void setProducts_java(List<Product_java> products_java) {
		this.products_java = products_java;
	}

	
	public void setProduct_java(Product_java p_java) {
		this.p_java = p_java;
	}

	

	public Product_java getProduct_java() {
		return p_java;
	}
	
	public List<Product_sql> getProducts_sql() {
		return products_sql;
	}

	public void setProducts_sql(List<Product_sql> products_sql) {
		this.products_sql = products_sql;
	}

	
	public void setProduct_sql(Product_sql p_sql) {
		this.p_sql = p_sql;
	}

	

	public Product_sql getProduct_sql() {
		return p_sql;
	}
	

	
	public List<Product_other> getProducts_other() {
		return products_other;
	}

	public void setProducts_other(List<Product_other> products_other) {
		this.products_other = products_other;
	}

	
	public void setProduct_other(Product_other p_other) {
		this.p_other = p_other;
	}

	

	public Product_other getProduct_other() {
		return p_other;
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
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public String getOutputContent() {
		return outputContent;
	}

	public void setOutputContent(String outputContent) {
		this.outputContent = outputContent;
	}
	
	public String getOutputName() {
		return outputName;
	}

	public void setOutputName(String outputName) {
		this.outputName = outputName;
	}
}
