package com.edubridge.contactapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edubridge.contactapp.model.Contact;
import com.edubridge.contactapp.util.DBUtils;

public class ContactDaoImpl implements ContactDao{

	@Override
	public int addContact(Contact c) {
		String INSERT = "insert into contact(name,email,mobile) values(?,?,?)";
		Connection con = DBUtils.getConnection();
		int status = 0;
		try {
			PreparedStatement ps = con.prepareStatement(INSERT);
			ps.setString(1,c.getName());
			ps.setString(2,c.getEmail());
			ps.setLong(3,c.getMobile());
			
			status = ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public List<Contact> getAllContacts() {
		String SELECT = "select*from contact";
		Connection con = DBUtils.getConnection();
		List<Contact> contact = new ArrayList<Contact>();
		
		try {
			PreparedStatement ps = con.prepareStatement(SELECT);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Contact c = new Contact();
				c.setId(rs.getInt("id"));
				c.setName(rs.getString("name"));
				c.setEmail(rs.getString("email"));
				c.setMobile(rs.getLong("mobile"));
				contact.add(c);
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return contact;
	}

	@Override
	public Contact getContact(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateContact(Contact c) {
	
			String update = "UPDATE Contact SET email = ?, mobile = ? WHERE name = ?";
	        Connection con = DBUtils.getConnection();
	        int status = 0;
	        try {
	            PreparedStatement ps = con.prepareStatement(update);
	            ps.setString(1, c.getEmail());
	            ps.setLong(2, c.getMobile());
	            ps.setString(3, c.getName());

	            status = ps.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return status;
	    
	}

	@Override
	public int deleteContact(String name) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteAllContacts() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Contact searchContacts(String name) {
		        Connection con = DBUtils.getConnection();
		        Contact c=null;
	            String SELECT = "SELECT * FROM contact WHERE name=?";
	            
		        try {
		           
		            PreparedStatement ps = con.prepareStatement(SELECT);
		            ps.setString(1, name);
		            ResultSet rs = ps.executeQuery();
		            if (rs.next()) {
		                c = new Contact();
		                c.setId(rs.getInt("id"));
		                c.setName(rs.getString("name"));
		                c.setEmail(rs.getString("email"));
		                c.setMobile(rs.getLong("mobile"));
		                
		            }
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		        return c ;
		    
		
	}

}
