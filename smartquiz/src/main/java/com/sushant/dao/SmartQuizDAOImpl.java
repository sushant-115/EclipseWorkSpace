package com.sushant.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("smartQuizDAOImpl")
public class SmartQuizDAOImpl implements SmartQuizDAO {
	
	@Autowired(required=false)
	private DataSource dataSource;
	private Connection con;

	

	
	public int insertUser(User user) throws SQLException {
		
			try {
				con=dataSource.getConnection();
			} catch (SQLException e) {
			System.out.println("Exception occured while establishing connection");	
					}
		
		PreparedStatement pst=con.prepareStatement("insert into user_details values(?,?,?,?)");
		pst.setString(1, user.getUsername());
		pst.setString(2,user.getUserEmail());
		pst.setString(3,user.getUserMobile());
		pst.setString(4,user.getPassword());
		
		int count =pst.executeUpdate();
		if(count==1)
			return 1;
		else
		return 0;
	}

	
	public int updatePassword(String username,String password) throws SQLException {
		
			try {
				con=dataSource.getConnection();
			} catch (SQLException e) {
			System.out.println("Exception occured while establishing connection");	
					}
		
	PreparedStatement pst=con.prepareStatement("update user_details set password=? where username=?");
	pst.setString(1, password);
	pst.setString(2, username);
	int count=pst.executeUpdate();
	if(count==1)
		return 1;
	else
		return 0;
	}

	
	public Set<String> searchUser(String username) throws SQLException {
		
			try {
				con=dataSource.getConnection();
			} catch (SQLException e) {
			System.out.println("Exception occured while establishing connection");	
					}
		
		PreparedStatement pst =con.prepareStatement("select username,mobile,email from user_details where username=?");
		pst.setString(1, username);
		ResultSet rs=pst.executeQuery();
		Set<String> list =new HashSet<String>();
		if(rs.next()){
		
		list.add(rs.getString(1));
		list.add(rs.getString(2));
		list.add(rs.getString(3));
		}
		return list;
	}

}
