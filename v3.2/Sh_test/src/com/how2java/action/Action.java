package com.how2java.action;
 
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.how2java.pojo.Message;
import com.how2java.pojo.Product;
import com.how2java.pojo.Product_java;
import com.how2java.pojo.Product_other;
import com.how2java.pojo.Product_sql;
 
public class Action {
	private List<?> p;
	
	private Product product;
	private List<Product> products;
    
	private Product_java product_java;
	private List<Product_java> products_java;
    
	private Product_sql product_sql;
	private List<Product_sql> products_sql;
    
	private Product_other product_other;
	private List<Product_other> products_other;
	
	private Message message;
	private List<Message> messages;
	
	
	public List<Message> getMessages() {
        return messages;
    }
 
    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
 
    public Message getMessage() {
        return message;
    }
 
    public void setMessage(Message message) {
        this.message = message;
    }
    
     
    public List<Product> getProducts() {
        return products;
    }
 
    public void setProducts(List<Product> products) {
        this.products = products;
    }
 
    public Product getProduct() {
        return product;
    }
 
    public void setProduct(Product product) {
        this.product = product;
    }
    
    public List<Product_java> getProducts_java() {
        return products_java;
    }
 
    public void setProducts_java(List<Product_java> products_java) {
        this.products_java = products_java;
    }
 
    public Product_java getProduct_java() {
        return product_java;
    }
 
    public void setProduct_java(Product_java product_java) {
        this.product_java = product_java;
    }
    
    
    public List<Product_sql> getProducts_sql() {
        return products_sql;
    }
 
    public void setProducts_sql(List<Product_sql> products_sql) {
        this.products_sql = products_sql;
    }
 
    public Product_sql getProduct_sql() {
        return product_sql;
    }
 
    public void setProduct_sql(Product_sql product_sql) {
        this.product_sql = product_sql;
    }
    
    
    public List<Product_other> getProducts_other() {
        return products_other;
    }
 
    public void setProducts_other(List<Product_other> products_other) {
        this.products_other = products_other;
    }
 
    public Product_other getProduct_other() {
        return product_other;
    }
 
    public void setProduct_other(Product_other product_other) {
        this.product_other = product_other;
    }
 
    
    public List<?> getP() {
        return p;
    }
 
    public void setP(List<?> p) {
        this.p = p;
    }
    
    
    public Object get(int id, String type) {
    	Object result = null;
 
        SessionFactory sf = new Configuration().configure()
                .buildSessionFactory();
        Session s = sf.openSession();
        
        if("java".equals(type)){
        	result = (Product_java) s.get(Product_java.class, id);
        }
        else if("sql".equals(type)){
        	result = (Product_sql) s.get(Product_sql.class, id);
        }
        else if("other".equals(type)){
        	result = (Product_other) s.get(Product_other.class, id);
        }
        else if("message".equals(type)){
        	result = (Message) s.get(Message.class, id);
        }
        else{
        	System.out.println(" ‰»Î¥ÌŒÛ£°");
        }
 
        s.close();
        sf.close();
        
        return result;
    }
    
    
    public void delete(int id, String type) {
    	List<Product> result = new ArrayList();
    	 
        SessionFactory sf = new Configuration().configure()
                .buildSessionFactory();
        Session s = sf.openSession();
        s.beginTransaction();
 
        if("java".equals(type)){
	        Product_java p = (Product_java) s.get(Product_java.class, id);
	        s.delete(p);
        }
        else if("sql".equals(type)){
	        Product_sql p = (Product_sql) s.get(Product_sql.class, id);
	        s.delete(p);
        }
        else if("other".equals(type)){
	        Product_other p = (Product_other) s.get(Product_other.class, id);
	        s.delete(p);
        }
        else if("message".equals(type)){
        	Message m = (Message) s.get(Message.class, id);
	        s.delete(m);
        }
        else{
        	
        }
	 
        s.getTransaction().commit();
        s.close();
        sf.close();
    }
    public void update(Object o, String typeName) {
    	 
        SessionFactory sf = new Configuration().configure()
                .buildSessionFactory();
        Session s = sf.openSession();
        s.beginTransaction();
        if("java".equals(typeName)){
	        Product_java java = (Product_java) o;
	        s.update(java);
        }
        else if("sql".equals(typeName)){
	        Product_sql sql = (Product_sql) o;
	        s.update(sql);
        }
        else if("other".equals(typeName)){
	        Product_other other = (Product_other) o;
	        s.update(other);
        }
        else if("message".equals(typeName)){
        	Message m = (Message) o;
	        s.update(m);
        }
        else{
        	
        }
 
        s.getTransaction().commit();
        s.close();
        sf.close();
    }
    public List<?> _list(String type) {
    	 
        SessionFactory sf = new Configuration().configure()
                .buildSessionFactory();
        Session s = sf.openSession();
 
        Query q = s.createQuery("from " + type + " p");
 
        p = q.list();
        
        if(null == p)
        	return null;
 
        
        s.close();
        sf.close();
		return p;
    }
}