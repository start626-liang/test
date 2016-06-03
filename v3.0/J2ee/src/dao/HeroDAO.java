package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.Message;

public class HeroDAO {
	private static String JDBC = "com.mysql.jdbc.Driver";
	private static String getJDBC ="jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8";
	private static String user = "root";
	private static String password = "171023";
	private static String SELECTFROM = "select * from ";

	public Message get(int i, String type) {
		Message hero = new Message();
		try {
			Class.forName(JDBC);
			Connection c = DriverManager.getConnection(getJDBC, user, password);
			Statement s = c.createStatement();

			String sql = SELECTFROM + type +" where id = " + i;

			ResultSet rs = s.executeQuery(sql);
			
			if (rs.next()) {
			int id = rs.getInt(1);
			String name = rs.getString(2);
			String content = rs.getString(3);
			String date = rs.getString(4);
			hero.setType(type);
			hero.setId(id);
			hero.setName(name);
			hero.setContent(content);
			hero.setDate(date);
			System.out.print("ID: " + id);
	         System.out.print(", First: " + name);
	         System.out.println(", Last: " + content);
			}

			s.close();

			c.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hero;
	}

	
	public void update(Message hero, String type) {
		System.out.println( hero.getId());
		try {
			Class.forName(JDBC);

			Connection c = DriverManager.getConnection(getJDBC, user, password);
			if(0==hero.getName().length() || null==hero.getName() || 0==hero.getContent().length() || null==hero.getContent()){
				c.close();
				return;
			}
			
			if(30==hero.getName().length() || 800==hero.getContent().length()){
				c.close();
				return;
			}
			
			
			String sql = "update " + type  + " set name= '" + hero.getName() + "', content = '" + hero.getContent() + "' where id = " + hero.getId();
			Statement  ps = c.createStatement();
			System.out.println(hero.getName() + "-------------------" + hero.getContent() + "-----------" + hero.getId());
			//String a = "update message set name= 'aaaaaaaaaaaaaaaaaa' where id = 12";
			ps.executeUpdate(sql);

			
			
			ps.close();

			c.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void delete(int id, String type) {
		try {
			Class.forName(JDBC);

			Connection c = DriverManager.getConnection(getJDBC, user, password);

			Statement s = c.createStatement();
			System.out.println(id + "-------------------");
			String sql = "delete from " + type + " where id = " + id + "";

			s.execute(sql);

			s.close();

			c.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

	public List<Message> list(String type) {
		List<Message> heros = new ArrayList<Message>();

		try {
			Class.forName(JDBC);

			Connection c = DriverManager.getConnection(getJDBC, user, password);

			String sql = SELECTFROM + type;

			PreparedStatement ps = c.prepareStatement(sql);
			

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Message hero = new Message();
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String content = rs.getString(3);
				
				if(content.length() > 500){
					 content = content.substring(0, 500);
				}
				
				hero.setType(type);
				hero.setId(id);
				hero.setName(name);
				hero.setContent(content);
				heros.add(hero);
				//System.out.println(content);
				//System.out.println(hero.getContent());
			}

			ps.close();

			c.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return heros;
	}

}