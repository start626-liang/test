package com.how2java.action;

import java.util.List;

import com.how2java.pojo.Message;
import com.how2java.pojo.Product_other;
import com.how2java.dao.ProductDAO;

public class MessageAction {
	private List<Message> messages;
	private Message m;
	
	private ProductDAO pdao;
	
	public String save(){
		boolean repetition = true;
		if(0==m.getContent().length() || null==m.getContent() || 0==m.getName().length() || null==m.getName()){
			return "error";
		}
		else{
			String hql = "from Message m where m.name='" + m.getName() + "' and m.content='" + m.getContent() + "'";
			messages = pdao.find(hql);
			
			int num = messages.size();
			if(0 == num)
				repetition = false;
		}
		
		
		if(repetition){
			return "repetition";
		}
		else{
		pdao.save(m);
		
		messages = pdao.find("from Message m");
		return "save";
		}
	}
	
	public String add(){
		messages = pdao.find("from Message m");
		
		return "add";
	}
	
	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages_other(List<Message> messages) {
		this.messages = messages;
	}

	
	public void setMessage(Message m) {
		this.m = m;
	}

	

	public Message getMessage() {
		return m;
	}
	
	public ProductDAO getPdao() {
		return pdao;
	}

	public void setPdao(ProductDAO pdao) {
		this.pdao = pdao;
	}
}
