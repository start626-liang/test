package com.how2java.action;


import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.how2java.dao.ProductDAO;
import com.how2java.pojo.Product;
import com.how2java.pojo.Product_backups;
import com.how2java.pojo.Product_java;
import com.how2java.pojo.Product_other;
import com.how2java.pojo.Product_sql;

public class ProductAction{
	static Log log = LogFactory.getLog(ProductAction.class);
	
	private ProductDAO pdao;
	private String type;
	
	private int outputId;
	private String outputType;
	private String outputContent;
	private String outputName;
	private String outputTime;

	private String moveType;
	
	
	private String findNull;
	
	private String saveRepetition;
	
	private List<Product> products;
	private Product p;
	
	private List<Product_java> products_java;
	private Product_java p_java;
	
	private List<Product_sql> products_sql;
	private Product_sql p_sql;
	
	private List<Product_other> products_other;
	private Product_other p_other;
	
	private List<Product_backups> products_backups;
	private Product_backups p_backups;
	
	
	
	
	public String show() {
		
		products_java = pdao.find("from Product_java p_java");
		products_sql = pdao.find("from Product_sql p_sql");
		products_other = pdao.find("from Product_other p_other");
		products = pdao.find("from Product p");
		
		if(type.equals("SQL")){
			p_sql = pdao.get(Product_sql.class, p_sql.getId());
			
			outputId = p_sql.getId();
			outputType = "SQL";
			outputName = p_sql.getName();
			outputContent = p_sql.getContent();
			outputTime =  p_sql.getDate();
		}
		else if(type.equals("JAVA")){
			p_java = pdao.get(Product_java.class, p_java.getId());
			
			outputId = p_java.getId();
			outputType = "JAVA";
			outputName = p_java.getName();
			outputContent = p_java.getContent();
			outputTime =  p_java.getDate();
		}
		else if(type.equals("Other")){
			p_other = pdao.get(Product_other.class, p_other.getId());
			
			//System.out.println(p_other.getId()+"-------------------");
			
			outputId = p_other.getId();
			outputType = "Other";
			outputName = p_other.getName();
			outputContent = p_other.getContent();
			outputTime =  p_other.getDate();
		}
		else{
			p= pdao.get(Product.class, p.getId());
			
			outputName = p.getName();
			outputContent = p.getContent();
			outputTime =  p.getDate();
		}
		
		return "show";
	}
	
	
	public String move(){
		System.out.println(moveType+ "++++++++++++++" +outputId + "```````````````````" + outputType + "---" +outputName +  "---" +outputContent +  "---" +outputTime);
		
		String hql1 = "from Product p where p.name='" 
		+ outputName + "' and p.content='" + outputContent 
		+ "'";
		List<Product> ps = pdao.find(hql1);
		
		int psnum = ps.size();
		
		if(0 == psnum || 1 != psnum){
			System.out.println("----------------------1");
			return "error";
		}
		else{
			Product p = ps.get(0);
			//System.out.println(psnum);
			//System.out.println(p.getId()+"`````````````````````");
			
			p.setType(moveType);
			pdao.update(p);
		}
		
		String hql2 = "from Product_backups ps where ps.name='" 
				+ outputName + "' and ps.content='" + outputContent 
				+ "'";
		List<Product_backups> pss = pdao.find(hql2);
				
		int pssnum = pss.size();
		System.out.println(1);
		if(0 == pssnum || 1 != pssnum){
			System.out.println("----------------------2");
			return "error";
		}
		else{
			Product_backups pb = pss.get(0);
			//System.out.println(psnum);
			//System.out.println(pb.getId()+"~~~~~~~`````````````````````");
					
			pb.setType(moveType);
			pdao.update(pb);
		}
		
		
		if("JAVA".equals(outputType)){
			Product_java java = pdao.get(Product_java.class, outputId); 
			
			pdao.delete(java);
		}
		else if("SQL".equals(outputType)){
			Product_sql sql = pdao.get(Product_sql.class, outputId); 
			
			pdao.delete(sql);
		}
		else if("Other".equals(outputType)){
			Product_other other = pdao.get(Product_other.class, outputId); 
			
			pdao.delete(other);
		}
		else{
			System.out.println("----------------------3");
			
			return "error";
		}
		
		
		if("JAVA".equals(moveType)){
			Product_java java = new Product_java();
			
			java.setName(outputName);
			java.setContent(outputContent);
			
			pdao.save(java);
		}
		else if("SQL".equals(moveType)){
			Product_sql sql = new Product_sql();
			
			sql.setName(outputName);
			sql.setContent(outputContent);
			
			pdao.save(sql);
		}
		else if("Other".equals(moveType)){
			Product_other other = new Product_other();
			
			other.setName(outputName);
			other.setContent(outputContent);
			
			pdao.save(other);
		}
		else{
			System.out.println("----------------------4");
			return "error";
		}
		
		
		
		
		
		
		products_java = pdao.find("from Product_java p_java");
		products_sql = pdao.find("from Product_sql p_sql");
		products_other = pdao.find("from Product_other p_other");
		return "move";
	}
	
	
	public String save(){	
		boolean repetition = true;
		
		if(0==p.getContent().length() || null==p.getContent() || 0==p.getName().length() || null==p.getName()){
			return "p_error";
		}
		else {
			String hql = "from Product p where p.name='" + p.getName() 
			+ "' and p.content='" + p.getContent() + "'";
			products = pdao.find(hql);
			
			int num = products.size();
		
			if(0 == num)
				repetition = false;
		}
			
		
		if(repetition){
			saveRepetition = p.getType();
			return "saveRepetition";
		}
		else{
			pdao.save(p);
			
			log.info("save Product name: " + p.getName());
			
			Product_backups p_backups = new Product_backups();
			p_backups.setName(p.getName());
			p_backups.setContent(p.getContent());
			p_backups.setType(p.getType());
			
			
			pdao.save(p_backups);
			
			log.info("save Product_backups name: " + p_backups.getName());
			
			
			if(p.getType().equals("JAVA")){
				Product_java p_java =new Product_java();
				
				p_java.setContent(p.getContent());
				p_java.setName(p.getName());
				
				pdao.save(p_java);
				
				log.info("save Product_java name: " + p_java.getName());
			}else if(p.getType().equals("SQL")){
				Product_sql p_sql =new Product_sql();
				
				p_sql.setContent(p.getContent());
				p_sql.setName(p.getName());
				
				pdao.save(p_sql);
				
				log.info("save Product_sql name: " + p_sql.getName());
			}
			else{
				Product_other p_other =new Product_other();
				
				p_other.setContent(p.getContent());
				p_other.setName(p.getName());
				
				pdao.save(p_other);
				
				log.info("save Product_other name: " + p_other.getName());
			}
			
			products_java = pdao.find("from Product_java p_java");
			products_sql = pdao.find("from Product_sql p_sql");
			products_other = pdao.find("from Product_other p_other");
			return "save";
		
		}
	}
	public void a(String a){
		System.out.println(a+"********");
	}
	public String add() {
		products_java = pdao.find("from Product_java p_java");
		products_sql = pdao.find("from Product_sql p_sql");
		products_other = pdao.find("from Product_other p_other");
		
		products = pdao.find("select distinct p.name from Product p");
		//products = pdao.find("SELECT DISTINCT p.type FROM Product p");
		
		if(products==null)
		System.out.println("22");
		else
			System.out.println("111111111111111");
		
		System.out.println("-------------");
		a("2222222222");
		a("333");
		
		return "add";
	}
	
	public String find(){
		if(0 != findName.length()){
			products = pdao.find("from Product p where p.name like ?", "%" + findName + "%");
			
			findNull = "";
		}
		else{
			findNull = "«Î ‰»Î≤È—Ø¥ ";
			
			products = null;
		}
		
		System.out.println("-------------");
		a("-------------");
		a("11111111");
		a("3311111111111113");
		
		return "find";
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

	
	public List<Product_backups> getProducts_backups() {
		return products_backups;
	}

	public void setProducts_backups(List<Product_backups> products_backups) {
		this.products_backups = products_backups;
	}

	
	public void setProduct_backups(Product_backups p_backups) {
		this.p_backups = p_backups;
	}

	

	public Product_backups getProduct_backups() {
		return p_backups;
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
	
	public String getOutputTime() {
		return outputTime;
	}

	public void setOutputTime(String outputTime) {
		this.outputTime = outputTime;
	}
	
	public String getFindNull() {
		return findNull;
	}

	public void setFindNull(String findNull) {
		this.findNull = findNull;
	}
	
	private String findName;
	
	public String getFindName() {
		return findName;
	}

	public void setFindName(String findName) {
		this.findName = findName;
	}
	
	public String getOutputType() {
		return outputType;
	}

	public void setOutputType(String outputType) {
		this.outputType = outputType;
	}
	
	
	public String getSaveRepetition() {
		return saveRepetition;
	}

	public void setSaveRepetition(String saveRepetition) {
		this.saveRepetition = saveRepetition;
	}
	
	public int getOutputId() {
		return outputId;
	}

	public void setOutputId(int outputId) {
		this.outputId = outputId;
	}
	
	public String getMoveType() {
		return moveType;
	}

	public void setMoveType(String moveType) {
		this.moveType = moveType;
	}
}
