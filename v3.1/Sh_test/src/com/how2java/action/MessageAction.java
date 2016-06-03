package com.how2java.action;
 
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.how2java.pojo.Message;
import com.how2java.pojo.Product;
 
public class MessageAction {
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
 
    
    public Message get(int id) {
    	Message result = null;
 
        SessionFactory sf = new Configuration().configure()
                .buildSessionFactory();
        Session s = sf.openSession();
 
        result = (Message) s.get(Message.class, id);
 
        s.close();
        sf.close();
        
        return result;
    }
    
    
    public void edit() {
    	Product result = null;
    	 
        SessionFactory sf = new Configuration().configure()
                .buildSessionFactory();
        Session s = sf.openSession();
 
        result = (Product) s.get(Product.class, message.getId());
 
        s.close();
        sf.close();
    }
    
    public void delete(int id) {
    	 
        SessionFactory sf = new Configuration().configure()
                .buildSessionFactory();
        Session s = sf.openSession();
        s.beginTransaction();
 
        Message m = (Message) s.get(Message.class, id);
 
        s.delete(m);
 
        s.getTransaction().commit();
        s.close();
        sf.close();
    }
    public void update(Object o) {
    	 
        SessionFactory sf = new Configuration().configure()
                .buildSessionFactory();
        Session s = sf.openSession();
        s.beginTransaction();
 
        s.update(o);
 
        s.getTransaction().commit();
        s.close();
        sf.close();
    }
    public List<Message> _list() {
    	 
        SessionFactory sf = new Configuration().configure()
                .buildSessionFactory();
        Session s = sf.openSession();
 
        Query q = s.createQuery("from Message m");
 
        messages = q.list();
 
        s.close();
        sf.close();
        
		return messages;
        
    }
 
}