package com.spring.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.spring.dao.EmployeeDAO;
@Service
public class EmployeeService {
	@Autowired
	private  EmployeeDAO employeeDAO;
	
public int deleteEmployee(int empno,String ename,int sal) throws SQLException{
	
	
		Connection con=employeeDAO.getConnection();
		String sql="insert into employee values(?,?,?)";
		PreparedStatement pst =con.prepareStatement(sql);
		pst.setInt(1, empno);
		pst.setString(2, ename);
		pst.setInt(3, sal);
		int c =pst.executeUpdate();
		
			
	return c;
}
	
	

}
